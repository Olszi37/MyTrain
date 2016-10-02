package com.olszi.model;

import org.springframework.cglib.core.Local;

import java.time.LocalTime;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Siny on 2016-10-02.
 */
public class SearchResult {

    private List<RoutePoint> results;

    private LocalTime departureTime;

    public SearchResult(List<RoutePoint> results, LocalTime departureTime) {
        this.results = results;
        this.departureTime = departureTime;
    }

    public SearchResult() {
    }

    public List<RoutePoint> getResults() {
        return results;
    }

    public void setResults(List<RoutePoint> results) {
        this.results = results;
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
