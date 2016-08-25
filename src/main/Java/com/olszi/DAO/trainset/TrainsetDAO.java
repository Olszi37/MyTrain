package com.olszi.DAO.trainset;

import com.olszi.model.Trainset;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
 */
public interface TrainsetDAO {

    public Long create(Trainset trainset);

    public void delete(Trainset trainset);

    public List<Trainset> getAll();

    public void update(Trainset trainset);

    public Trainset getById(Long id);

    public Trainset getByName(String name);

    public Trainset getByNickname(String nickname);
}
