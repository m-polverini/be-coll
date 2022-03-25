package com.carseller.cars.services;

import com.carseller.cars.domain.SizeWheel;

public interface ISizeWheelService {

    /**
     * find or save new size wheel
     * @param sizeWheel String | size wheel to find or to save
     * @return SizeWheel
     */
    public SizeWheel findOrSaveByDesc(String sizeWheel);
}
