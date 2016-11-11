package com.olszi.controller;

import com.olszi.model.Course;
import com.olszi.model.Station;
import com.olszi.service.CourseService;
import com.olszi.service.StationService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOlszi on 2016-09-26.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StationService stationService;
    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(method = RequestMethod.GET, value = "get/size")
    public @ResponseBody int getTableSize(){
        return courseService.rowCount();
    }

    @RequestMapping(method = RequestMethod.DELETE, value="clear")
    public void clearTable(){
        courseService.clearTable();
    }

    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type=multipart/form-data")
    public @ResponseBody int setCoursesByFile(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<Course> courses = getDataFromFile(file);

        for(Course course : courses){
            courseService.create(course);
        }

        return courses.size();
    }

    public List<Course> getDataFromFile(File file) throws IOException, InvalidFormatException {

        List<Course> courses = new ArrayList<Course>();
        List<Station> stations = stationService.getAll();

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheetAt(0);

        for(Row row : sheet){
            if(row.getRowNum() != 0){
                Course course = new Course();

                course.setCourseID((long) row.getCell(0).getNumericCellValue());
                course.setFrom(stations.get((int) row.getCell(1).getNumericCellValue() - 1));
                course.setDestiny(stations.get((int) row.getCell(2).getNumericCellValue() - 1));
                course.setDescription(row.getCell(3).getStringCellValue());

                courses.add(course);
            }
        }

        return courses;
    }
}
