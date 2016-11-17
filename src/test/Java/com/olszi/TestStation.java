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
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
        Station station = new Station((long) 801, "Warszawa Zachodnia", "Mazowieckie");
        service.create(station);

        assertNotNull(service.getById((long) 801));
    }

    @Test
    @Transactional
    public void testUptade(){
        Station station = new Station((long) 801, "Lublin", "Lubelskie");
        service.create(station);
        station.setName("Kraków główny");
        station.setProvince("Małopolskie");
        service.update(station);

        Station stationToMatch = service.getById((long) 801);
        assertEquals(new Long(801), stationToMatch.getStationID());
        assertEquals("Kraków główny", stationToMatch.getName());
        assertEquals("Małopolskie", stationToMatch.getProvince());
    }

    @Test
    @Transactional
    public void testDelete(){
        Station station = new Station((long) 801, "Lublin", "Lubelskie");
        service.create(station);
        service.delete(station);

        assertNull(service.getById((long) 801));
    }

    @Test
    @Transactional
    public void testGetAll(){

        int before = service.rowCount();

        List<Station> stations = new ArrayList<>();
        stations.add(new Station((long) 801, "Lublin", "Lubelskie"));
        stations.add(new Station((long) 802, "Kraków głowny", "Małopolskie"));
        stations.add(new Station((long) 803, "Warszawa zachodnia", "Mazowieckie"));

        for(Station station : stations){
            service.create(station);
        }

        if(before == 0)
            assertEquals(3, service.getAll().size());
        else
            assertEquals(3 + before, service.getAll().size());
    }
}
