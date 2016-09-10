package com.olszi.controller;

import com.olszi.service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MOlszi on 2016-09-10.
 */

@RestController
public class StationController {

    @Autowired
    private StationService stationService;
}
