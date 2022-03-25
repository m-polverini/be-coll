package com.carseller.cars.services;

import com.carseller.cars.models.VehicleDTO;

import java.util.List;

public interface IVehicleService {

    /**
     * insert all vehicles readed from xml
     * @param vehicles List<VehicleDTO> | vehicles to insert
     * @return List<VehicleDTO>
     */
    public List<VehicleDTO> ingestVehicles(List<VehicleDTO> vehicles);

    /**
     * find vehicle by id
     * @param idVehicle int | id of vehicle
     * @return VehicleDTO
     */
    public VehicleDTO findById(int idVehicle);

    /**
     * find vehicle by name
     * @param name String | name of vehicle
     * @return VehicleDTO
     */
    public VehicleDTO findVehicle(String name);

}
