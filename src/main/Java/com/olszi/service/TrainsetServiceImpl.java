package com.olszi.service;

import com.olszi.dao.TrainsetDAO;
import com.olszi.model.Trainset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class TrainsetServiceImpl implements TrainsetService {

    private TrainsetDAO trainsetDAO;

    @Autowired
    public TrainsetServiceImpl(TrainsetDAO trainsetDAO) {
        this.trainsetDAO = trainsetDAO;
    }

    @Override
    public void create(Trainset trainset) {
        trainsetDAO.create(trainset);
    }

    @Override
    public void update(Trainset trainset) {
        trainsetDAO.update(trainset);
    }

    @Override
    public void delete(Trainset trainset) {
        trainsetDAO.delete(trainset);
    }

    @Override
    public Trainset getById(Long id) {
        return trainsetDAO.getById(id);
    }

    @Override
    public List<Trainset> getAll() {
        return trainsetDAO.getAll();
    }
}
