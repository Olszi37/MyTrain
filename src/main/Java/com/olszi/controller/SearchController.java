package com.olszi.controller;

import com.olszi.model.RoutePoint;
import com.olszi.model.SearchResult;
import com.olszi.model.Station;
import com.olszi.service.CourseService;
import com.olszi.service.RoutePointService;
import com.olszi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
    @Autowired
    CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody List<SearchResult> searchConnections(HttpServletRequest request){
        Station initialStop = stationService.getById(new Long(request.getHeader("initialStop")));
        Station finalStop = stationService.getById(new Long(request.getHeader("finalStop")));

        List<RoutePoint> initialStopResults = routePointService.getByStation(initialStop);
        List<RoutePoint> finalStopResults = routePointService.getByStation(finalStop);

        List<SearchResult> results = searchWithoutChanges(initialStopResults, finalStopResults);

        results.sort((o1, o2) -> o1.getDepartureTime().compareTo(o2.getDepartureTime()));

        return results;
    }

    public List<SearchResult> searchWithoutChanges(List<RoutePoint> initialStops, List<RoutePoint> finalStops){

        List<SearchResult> results = new ArrayList<SearchResult>();

        for(RoutePoint routePoint1 : initialStops)
        {
            for(RoutePoint routePoint2 : finalStops)
            {
                if(routePoint1.getCourse().getCourseID() == routePoint2.getCourse().getCourseID()
                        && routePoint1.getPointID() < routePoint2.getPointID())
                {
                    SearchResult result = new SearchResult();
                    result.setResults(routePointService
                            .getByCourseBetweenStations(routePoint1.getCourse(), routePoint1.getStation(), routePoint2.getStation()));
                    result.setDepartureTime(routePoint1.getDeparture());

                    results.add(result);
                }
            }
        }

        return results;
    }

    public List<SearchResult> searchWithChanges(List<SearchResult> results, List<RoutePoint> initialStops,
                                                List<RoutePoint> finalStops){

        List<List<RoutePoint>> initialCourse = new ArrayList<>();
        List<List<RoutePoint>> finalCourse = new ArrayList<>();

        //jesli course z initial stop zawiera stacje wspolna z course z final stop

        initialCourse.addAll(initialStops.stream().map(routePoint1 ->
                routePointService.getByCourse(routePoint1.getCourse())).collect(Collectors.toList()));

        finalCourse.addAll(finalStops.stream().map(routePoint2 ->
                routePointService.getByCourse(routePoint2.getCourse())).collect(Collectors.toList()));

        return results;
    }
}
