package com.carseller.cars.services;

import com.carseller.cars.domain.TypeEngine;
import com.carseller.cars.models.TypeEngineDTO;

public interface ITypeEngineService {

    /**
     * find or save new type engine
     * @param typeEngine String | type engine to find or to save
     * @return TypeEngineDTO
     */
    public TypeEngine findOrSaveByDesc(String typeEngine);
}
