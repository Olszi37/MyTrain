package com.olszi.service.carriage;

import com.olszi.DAO.carriage.CarriageDAO;
import com.olszi.model.carriage.Carriage;
import com.olszi.model.carriage.CarriageType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
 */

@Service
public class CarriageServiceImpl implements CarriageService {

    private CarriageDAO carriageDAO;

    @Autowired
    public CarriageServiceImpl(CarriageDAO carriageDAO) {
        this.carriageDAO = carriageDAO;
    }

    @Override
    public Long create(Carriage carriage) {
        return carriageDAO.create(carriage);
    }

    @Override
    public void delete(Carriage carriage) {
        carriageDAO.delete(carriage);
    }

    @Override
    public List<Carriage> getByTrainsetID(Long trainsetID) {
        return carriageDAO.getByTrainsetID(trainsetID);
    }

    @Override
    public List<Carriage> getBytype(CarriageType type) {
        return carriageDAO.getBytype(type);
    }
}
