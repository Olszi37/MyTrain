package com.olszi.service;

import com.olszi.model.Trainset;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface TrainsetService {

    public void create(Trainset trainset);

    public void update(Trainset trainset);

    public void delete(Trainset trainset);

    public Trainset getById(Long id);

    public List<Trainset> getAll();
}
