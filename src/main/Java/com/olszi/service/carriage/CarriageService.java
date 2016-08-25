package com.olszi.service.carriage;

import com.olszi.model.carriage.Carriage;
import com.olszi.model.carriage.CarriageType;

import java.util.List;

/**
 * Created by MOlszi on 2016-08-25.
 */
public interface CarriageService {

    public Long create(Carriage carriage);

    public void delete(Carriage carriage);

    public List<Carriage> getByTrainsetID(Long trainsetID);

    public List<Carriage> getBytype(CarriageType type);
}
