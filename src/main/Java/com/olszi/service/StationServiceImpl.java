package com.olszi.service;

import com.olszi.dao.StationDAO;
import com.olszi.model.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class StationServiceImpl implements StationService {

    private StationDAO stationDAO;

    @Autowired
    public StationServiceImpl(StationDAO stationDAO) {
        this.stationDAO = stationDAO;
    }

    @Override
    public void create(Station station) {
        stationDAO.create(station);
    }

    @Override
    public void update(Station station) {
        stationDAO.update(station);
    }

    @Override
    public void delete(Station station) {
        stationDAO.delete(station);
    }

    @Override
    public Station getById(Long id) {
        return stationDAO.getById(id);
    }

    @Override
    public List<Station> getAll() {
        return stationDAO.getAll();
    }

    @Override
    public int rowCount() {
        return stationDAO.rowCount();
    }

    @Override
    public void clearTable() {
        stationDAO.clearTable();
    }
}
