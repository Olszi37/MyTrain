package com.olszi.controller;

import com.olszi.model.RoutePoint;
import com.olszi.model.SearchResult;
import com.olszi.model.Station;
import com.olszi.model.Trainset;
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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Siny on 2016-10-01.
 */

@RestController
@RequestMapping(value = "search")
public class SearchController {

    @Autowired
    private StationService stationService;
    @Autowired
    private RoutePointService routePointService;
    @Autowired
    private CourseService courseService;

    @RequestMapping(method = RequestMethod.POST)
    public @ResponseBody List<SearchResult> searchConnections(HttpServletRequest request){
        Station initialStop = stationService.getById(new Long(request.getHeader("initialStop")));
        Station finalStop = stationService.getById(new Long(request.getHeader("finalStop")));

        List<RoutePoint> initialStopResults = routePointService.getInitialStations(initialStop);
        List<RoutePoint> finalStopResults = routePointService.getFinalStations(finalStop);

        List<SearchResult> results = getResults(initialStopResults, finalStopResults);

        if(!results.isEmpty())
            results.sort((o1, o2) -> o1.getDepartureTime().compareTo(o2.getDepartureTime()));

        return results;
    }

    public List<SearchResult> getResults(List<RoutePoint> initialStops, List<RoutePoint> finalStops){

        List<SearchResult> results = new ArrayList<SearchResult>();

        for(RoutePoint point1 : initialStops)
        {
            for(RoutePoint point2 : finalStops)
            {
                if(point1.getCourse().getCourseID() == point2.getCourse().getCourseID()
                        && point1.getTrainset().getTrainsetID() == point2.getTrainset().getTrainsetID())
                {
                    SearchResult result = new SearchResult();

                    result.addResults(routePointService.getByCourseTrainsetAndStations(
                            point1.getCourse(), point1.getTrainset(), point1.getStation(), point2.getStation()));

                    results.add(result);
                }
                else{
                    List<RoutePoint> initialCourse = routePointService.getByCourseAndTrainset(point1.getCourse(), point1.getTrainset());
                    List<RoutePoint> finalCourse = routePointService.getByCourseAndTrainset(point2.getCourse(), point2.getTrainset());

                    HashMap<String, RoutePoint> mutualStations = findMutualStation(initialCourse, finalCourse);

                    if(mutualStations != null){
                        if(mutualStations.get("point3").getArrival().isBefore(mutualStations.get("point4").getDeparture())){
                            SearchResult result = new SearchResult();

                            result.addResults(routePointService.getByCourseTrainsetAndStations(
                                    point1.getCourse(), point1.getTrainset(), point1.getStation(), mutualStations.get("point3").getStation()));
                            result.addResults(routePointService.getByCourseTrainsetAndStations(
                                    point2.getCourse(), point2.getTrainset(), mutualStations.get("point4").getStation(), point2.getStation()));

                            results.add(result);
                        }
                    }
                }
            }
        }

        return results;
    }

    public HashMap<String, RoutePoint> findMutualStation(List<RoutePoint> initialCourse, List<RoutePoint> finalCourse){

        HashMap<String, RoutePoint> map = new HashMap<>();

        for(RoutePoint point3 : initialCourse){
            for(RoutePoint point4 : finalCourse){
                if(point3.getStation().getStationID() == point4.getStation().getStationID()){
                    map.put("point3", point3);
                    map.put("point4", point4);

                    return map;
                }
            }
        }

        return null;
    }
}
