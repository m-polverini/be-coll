package com.carseller.cars.services;

import com.carseller.cars.domain.Wheel;

public interface IWheelService {

    /**
     * find or save new wheel
     * @param sizeWheel String | size of the wheel
     * @param typeWheel String | type of the wheel
     * @return Engine
     */
    public Wheel findOrSave(String sizeWheel, String typeWheel);
}
