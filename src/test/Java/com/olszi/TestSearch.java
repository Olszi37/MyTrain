package com.olszi;

import com.olszi.config.HibernateConfig;
import com.olszi.config.WebAppConfig;
import com.olszi.model.SearchResult;
import org.json.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.*;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Siny on 2016-12-10.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, WebAppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class TestSearch {

    @Test
    public void testSearch(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/myTrain/search";

        JSONObject request = new JSONObject();
        request.put("initialStop", 229);
        request.put("finalStop", 518);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccessControlAllowOrigin("*");

        HttpEntity<String> entity = new HttpEntity<>(request.toString(), headers);

        ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode() == HttpStatus.OK){
            JSONObject responseJSON = new JSONObject(response.getBody());
        } else {
            System.out.println("Gone wrong");
        }

        //asserty
    }
}
