package com.olszi.controller;

import com.olszi.model.Station;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Siny on 2016-10-01.
 */

@RestController
@RequestMapping(value = "search")
public class SearchController {

    @RequestMapping(method = RequestMethod.POST)
    public void searchConnections(HttpServletRequest request){
        Station initialStop;
        Station finalStop;

        // id or name


    }
}
