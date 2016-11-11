package com.olszi.service;

import com.olszi.model.Carriage;
import com.olszi.model.Trainset;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface CarriageService {

    public void create(Carriage carriage);

    public void update(Carriage carriage);

    public void delete(Carriage carriage);

    public Carriage getById(Long id);

    public List<Carriage> getByTrainset(Trainset trainset);

    public int rowCount();

    public void clearTable();
}
