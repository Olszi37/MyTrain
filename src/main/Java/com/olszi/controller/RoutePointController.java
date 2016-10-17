package com.olszi.controller;

import com.olszi.model.Course;
import com.olszi.model.RoutePoint;
import com.olszi.model.Station;
import com.olszi.model.Trainset;
import com.olszi.service.CourseService;
import com.olszi.service.RoutePointService;
import com.olszi.service.StationService;
import com.olszi.service.TrainsetService;
import com.olszi.system.FileUpload;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by MOlszi on 2016-09-27.
 */

@CrossOrigin
@RestController
@RequestMapping(value = "routePoint")
public class RoutePointController {

    @Autowired
    private RoutePointService routePointService;
    @Autowired
    private StationService stationService;
    @Autowired
    private CourseService courseService;
    @Autowired
    private TrainsetService trainsetService;
    @Autowired
    private FileUpload fileUpload;

    @RequestMapping(method = RequestMethod.POST, value = "set/file", headers = "Content-Type=multipart/*")
    public @ResponseBody List<RoutePoint> setRoutePointsByFile(MultipartHttpServletRequest request) throws IOException, InvalidFormatException {

        File file = fileUpload.upload(request);
        List<RoutePoint> points = getDataFromFile(file);

        for(RoutePoint point : points){
            routePointService.create(point);
        }

        return points;
    }

    public List<RoutePoint> getDataFromFile(File file) throws IOException, InvalidFormatException {

        List<RoutePoint> points = new ArrayList<RoutePoint>();

        List<Station> stations = stationService.getAll();
        List<Course> courses = courseService.getAll();
        List<Trainset> trainsets = trainsetService.getAll();

        Workbook workbook = WorkbookFactory.create(file);

        for (Row row : workbook.getSheetAt(0)){
            if (row.getRowNum() != 0){

                RoutePoint  point = new RoutePoint();

                point.setCourse(courses.get((int) row.getCell(1).getNumericCellValue() - 1 ));
                point.setStation(stations.get((int) row.getCell(2).getNumericCellValue() - 1));

                if(row.getCell(3).getDateCellValue() == null){
                    point.setArrival(null);
                }else{
                    Instant arrival = row.getCell(3).getDateCellValue().toInstant();
                    point.setArrival(LocalDateTime.ofInstant(arrival, ZoneId.systemDefault()).toLocalTime());
                }

                if(row.getCell(4).getDateCellValue() == null){
                    point.setDeparture(null);
                }else{
                    Instant departure = row.getCell(4).getDateCellValue().toInstant();
                    point.setDeparture(LocalDateTime.ofInstant(departure, ZoneId.systemDefault()).toLocalTime());
                }
                
                point.setDistance((int) row.getCell(5).getNumericCellValue());
                point.setTrainset(trainsets.get((int) row.getCell(6).getNumericCellValue() - 1));

                points.add(point);
            }
        }

        return points;
    }
}
