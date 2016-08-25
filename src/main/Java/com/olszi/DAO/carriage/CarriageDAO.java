package com.olszi.DAO.carriage;

import com.olszi.model.carriage.Carriage;
import com.olszi.model.carriage.CarriageType;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
 */
public interface CarriageDAO {

    public Long create(Carriage carriage);

    public void delete(Carriage carriage);

    public List<Carriage> getByTrainsetID(Long trainsetID);

    public List<Carriage> getBytype(CarriageType type);
}
