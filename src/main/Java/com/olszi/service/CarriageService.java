package com.olszi.service;

import com.olszi.model.Carriage;

/**
 * Created by MOlszi on 2016-09-10.
 */
public interface CarriageService {

    public void create(Carriage carriage);

    public void update(Carriage carriage);

    public void delete(Carriage carriage);

    public Carriage getById(Long id);
}
