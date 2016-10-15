package com.olszi.dao;

import com.olszi.model.Carriage;
import com.olszi.model.Trainset;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-07.
 */
public interface CarriageDAO {

    public void create(Carriage carriage);

    public void update(Carriage carriage);

    public void delete(Carriage carriage);

    public Carriage getById(Long id);

    public List<Carriage> getByTrainset(Trainset trainset);
}
