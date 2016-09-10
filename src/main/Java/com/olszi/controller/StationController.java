package com.olszi.controller;

import com.olszi.model.Station;
import com.olszi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@RestController
@RequestMapping(value = "station")
public class StationController {

    @Autowired
    private StationService stationService;

    @RequestMapping(method = RequestMethod.POST, value = "set/file")
    public @ResponseBody List<Station> setStationsByFile(){
        return null;
    }
}
