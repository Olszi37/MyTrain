package com.olszi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;

/**
 * Created by MOlszi on 2016-09-30.
 */

@RestController
public class TestController {

    @RequestMapping(method = RequestMethod.GET, value = "test")
    public @ResponseBody ResponseEntity testRest(){
        return new ResponseEntity<String>("App is up", HttpStatus.OK);
    }
}
