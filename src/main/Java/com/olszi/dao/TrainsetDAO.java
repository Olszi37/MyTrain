package com.olszi.dao;

import com.olszi.model.Trainset;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface TrainsetDAO {

    public void create(Trainset trainset);

    public void update(Trainset trainset);

    public void delete(Trainset trainset);

    public Trainset getById(Long id);
}
