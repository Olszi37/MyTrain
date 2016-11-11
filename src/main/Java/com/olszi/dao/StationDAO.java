package com.olszi.dao;

import com.olszi.model.Station;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-08.
 */
public interface StationDAO {

    public void create(Station station);

    public void update(Station station);

    public void delete(Station station);

    public Station getById(Long id);

    public List<Station> getAll();

    public int rowCount();

    public void clearTable();
}
