package com.carseller.cars.services;

import com.carseller.cars.domain.TypeWheel;

public interface ITypeWheelService {

    /**
     * find or save new type wheel
     * @param typeWheel String | type wheel to find or to save
     * @return TypeWheelDTO
     */
    public TypeWheel findOrSaveByDesc(String typeWheel);
}
