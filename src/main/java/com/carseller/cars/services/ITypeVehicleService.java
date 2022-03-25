package com.carseller.cars.services;

import com.carseller.cars.domain.TypeVehicle;

public interface ITypeVehicleService {

    /**
     * find or save new type vehicle
     * @param typeVehicle String | type vehicle to find or to save
     * @return TypeVehicleDTO
     */
    public TypeVehicle findOrSaveByDesc(String typeVehicle);
}
