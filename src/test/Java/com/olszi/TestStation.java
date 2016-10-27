package com.olszi;

import com.olszi.config.HibernateConfig;
import com.olszi.config.WebAppConfig;
import com.olszi.model.Station;
import com.olszi.service.StationService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertNotNull;

/**
 * Created by MOlszi on 2016-10-27.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, WebAppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class TestStation {

    @Autowired
    private StationService service;

    @Test
    @Transactional
    public void testCreate(){
        Station station = new Station((long) 1, "Warszawa Zachodnia", "Mazowieckie");
        service.create(station);

        assertNotNull(service.getById((long)1));
    }
}
