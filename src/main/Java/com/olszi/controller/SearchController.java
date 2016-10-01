package com.olszi.controller;

import com.olszi.model.RoutePoint;
import com.olszi.model.Station;
import com.olszi.service.RoutePointService;
import com.olszi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Siny on 2016-10-01.
 */

@RestController
@RequestMapping(value = "search")
public class SearchController {

    @Autowired
    StationService stationService;
    @Autowired
    RoutePointService routePointService;

    @RequestMapping(method = RequestMethod.POST)
    public void searchConnections(HttpServletRequest request){
        Station initialStop = stationService.getById(new Long(request.getHeader("initialStop")));
        Station finalStop = stationService.getById(new Long(request.getHeader("finalStop")));

        List<RoutePoint> initialStopResults = routePointService.getByStation(initialStop);
        List<RoutePoint> finalStopResults = routePointService.getByStation(finalStop);

        Long courseId;

        for(RoutePoint routePoint1 : initialStopResults){
            for(RoutePoint routePoint2 : finalStopResults){
                if(routePoint1.getCourse().getCourseID() == routePoint2.getCourse().getCourseID())
                    courseId = routePoint1.getCourse().getCourseID();
                
            }
        }
    }
}
