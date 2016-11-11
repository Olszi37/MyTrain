package com.olszi;

import com.olszi.config.HibernateConfig;
import com.olszi.config.WebAppConfig;
import com.olszi.model.Trainset;
import com.olszi.service.TrainsetService;
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

/**
 * Created by MOlszi on 2016-11-03.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class, WebAppConfig.class}, loader = AnnotationConfigWebContextLoader.class)
@WebAppConfiguration
public class TestTrainset {

    @Autowired
    TrainsetService trainsetService;

    @Test
    @Transactional
    public void testRowCount(){
        List<Trainset> trainsetList = new ArrayList<>();
        trainsetList.add(new Trainset(new Long(800), "TLK 80011/1", "Mateusz"));
        trainsetList.add(new Trainset(new Long(801), "TLK 80011/2", "Morfeusz"));
        trainsetList.add(new Trainset(new Long(802), "TLK 80011/3", "Magdalena"));
        trainsetList.add(new Trainset(new Long(803), "TLK 80011/4", "Michal"));

        for(Trainset trainset : trainsetList){
            trainsetService.create(trainset);
        }

        assertEquals(4, trainsetService.rowCount());
    }

    @Test
    @Transactional
    public void testClearTable(){
        List<Trainset> trainsetList = new ArrayList<>();
        trainsetList.add(new Trainset(new Long(800), "TLK 80011/1", "Mateusz"));
        trainsetList.add(new Trainset(new Long(801), "TLK 80011/2", "Morfeusz"));
        trainsetList.add(new Trainset(new Long(802), "TLK 80011/3", "Magdalena"));
        trainsetList.add(new Trainset(new Long(803), "TLK 80011/4", "Michal"));

        for(Trainset trainset : trainsetList){
            trainsetService.create(trainset);
        }

        trainsetService.clearTable();

        assertEquals(0, trainsetService.rowCount());
    }
}
