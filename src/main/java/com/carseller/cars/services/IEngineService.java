package com.carseller.cars.services;

import com.carseller.cars.domain.Engine;

public interface IEngineService {

    /**
     * find or save new engine
     * @param power int | power of the engine
     * @param typeEngine String | type engine
     * @return Engine
     */
    public Engine findOrSave(int power, String typeEngine);
}
