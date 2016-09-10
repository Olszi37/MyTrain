package com.olszi.service;

import com.olszi.dao.CarriageDAO;
import com.olszi.model.Carriage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by MOlszi on 2016-09-10.
 */

@Service
public class CarriageServiceImpl implements CarriageService {

    private CarriageDAO carriageDAO;

    @Autowired
    public CarriageServiceImpl(CarriageDAO carriageDAO) {
        this.carriageDAO = carriageDAO;
    }

    @Override
    public void create(Carriage carriage) {
        carriageDAO.create(carriage);
    }

    @Override
    public void update(Carriage carriage) {
        carriageDAO.update(carriage);
    }

    @Override
    public void delete(Carriage carriage) {
        carriageDAO.delete(carriage);
    }

    @Override
    public Carriage getById(Long id) {
        return carriageDAO.getById(id);
    }
}
