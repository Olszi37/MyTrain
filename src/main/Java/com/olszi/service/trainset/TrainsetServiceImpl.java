package com.olszi.service.trainset;

import com.olszi.DAO.trainset.TrainsetDAO;
import com.olszi.model.Trainset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
 */

@Service
public class TrainsetServiceImpl implements TrainsetService {

    private TrainsetDAO trainsetDAO;

    @Autowired
    public TrainsetServiceImpl(TrainsetDAO trainsetDAO) {
        this.trainsetDAO = trainsetDAO;
    }

    @Override
    public Long create(Trainset trainset) {
        return trainsetDAO.create(trainset);
    }

    @Override
    public void delete(Trainset trainset) {
        trainsetDAO.delete(trainset);
    }

    @Override
    public List<Trainset> getAll() {
        return trainsetDAO.getAll();
    }

    @Override
    public void update(Trainset trainset) {
        trainsetDAO.update(trainset);
    }

    @Override
    public Trainset getById(Long id) {
        return trainsetDAO.getById(id);
    }

    @Override
    public Trainset getByName(String name) {
        return trainsetDAO.getByName(name);
    }

    @Override
    public Trainset getByNickname(String nickname) {
        return trainsetDAO.getByNickname(nickname);
    }
}
