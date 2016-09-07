package com.olszi.dao;

import com.olszi.model.Carriage;

/**
 * Created by MOlszi on 2016-09-07.
 */
public interface CarriageDAO {

    public void create(Carriage carriage);

    public void update(Carriage carriage);

    public void delete(Carriage carriage);
}
