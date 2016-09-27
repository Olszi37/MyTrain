package com.olszi.controller;

import com.olszi.model.Course;
import com.olszi.model.Station;
import com.olszi.service.CourseService;
import com.olszi.service.StationService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOlszi on 2016-09-26.
 */

@RestController
@RequestMapping(value = "course")
public class CourseController {

    @Autowired
    private CourseService courseService;
    @Autowired
    private StationService stationService;
    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type = multipart/*")
    public @ResponseBody List<Course> setCoursesByFile(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<Course> courses = getDataFromFile(file);

        for(Course course : courses){
            courseService.create(course);
        }

        return courses;
    }

    public List<Course> getDataFromFile(File file) throws IOException, InvalidFormatException {

        List<Course> courses = new ArrayList<Course>();
        List<Station> stations = stationService.getAll();

        Workbook workbook = WorkbookFactory.create(file);

        Sheet sheet = workbook.getSheetAt(0);

        for(Row row : sheet){
            if(row.getRowNum() != 0){
                Course course = new Course();

                for(Cell cell : row){
                    if(cell.getColumnIndex() != 0)
                    {
                        if(cell.getColumnIndex() == 1)
                            course.setFrom(stations.get((int)cell.getNumericCellValue()-1));

                        if(cell.getColumnIndex() == 2)
                            course.setDestiny(stations.get((int)cell.getNumericCellValue()-1));
                    }
                }

                courses.add(course);
            }
        }

        return courses;
    }
}
