package com.olszi;

import com.olszi.config.HibernateConfig;
import com.olszi.config.WebAppConfig;
import com.olszi.model.SearchResult;
import io.restassured.RestAssured;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Siny on 2016-12-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, WebAppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class TestSearch {

//    private MockMvc mockMvc;
//
//    @Autowired
//    private WebApplicationContext ctx;
//
//    @Before
//    public void setUp(){
//        mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
//    }

    @Before
    public void setup(){
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/MyTrain/";
    }

    @Test
    public void testSearch() throws Exception{

        String request = "{ \"initialStop\" : 229, \"finalStop\" : 518 }";

        given().contentType("application/json").body(request).when().post("/search").then().statusCode(200);

//        MvcResult result = mockMvc.perform(post("/MyTrain/search").contentType(MediaType.APPLICATION_JSON).content(request))
//        .andExpect(status().is(200)).andReturn();
//
//        System.out.println("wynik: " + result.getResponse().getContentAsString());
    }
}
