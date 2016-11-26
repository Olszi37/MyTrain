package com.olszi.model;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Siny on 2016-10-02.
 */
public class SearchResult {

    private List<List<RoutePoint>> results;

    private LocalTime departureTime;

    public SearchResult(List<List<RoutePoint>> results, LocalTime departureTime) {
        this.results = results;
        this.departureTime = departureTime;
    }

    public SearchResult() {
        results = new ArrayList<List<RoutePoint>>();
    }

    public List<List<RoutePoint>> getResults() {
        return results;
    }

    public void addResults(List<RoutePoint> results) {
        this.results.add(results);
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalTime departureTime) {
        this.departureTime = departureTime;
    }

    public int compareTo(SearchResult result){
        return getDepartureTime().compareTo(result.getDepartureTime());
    }
}
