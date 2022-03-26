package com.carseller.cars.controllers;

import com.carseller.cars.constants.Log;
import com.carseller.cars.constants.Url;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.services.IVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Slf4j
public class VehicleController {

    @Autowired
    private IVehicleService vehicleService;

    @GetMapping(path = Url.VEHICLE + Url.VEHICLE_ID, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    VehicleDTO findVehicleById(@PathVariable Integer idVehicle) {
        log.info(Log.FIND_VEHICLE_BY_ID, VehicleController.class.getName(), Log.M_FIND_VEHICLE_BY_ID, idVehicle, Log.START);
        VehicleDTO vehicle = vehicleService.findById(idVehicle);
        log.info("vehicle extracted from id {}: {}", idVehicle, vehicle.toString());
        log.info(Log.FIND_VEHICLE_BY_ID, VehicleController.class.getName(), Log.M_FIND_VEHICLE_BY_ID, idVehicle, Log.END);
        return vehicle;
    }
    @GetMapping(path = Url.VEHICLE, produces = {"application/json"})
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody
    List<VehicleDTO> findVehicle(@RequestParam(required = false) String name) {
        log.info(Log.FIND_VEHICLE, VehicleController.class.getName(), Log.M_FIND_VEHICLE, name, Log.START);
        List<VehicleDTO> vehicles = vehicleService.findVehicle(name);
        log.info("vehicles extracted from name {}: {}", name, vehicles.toString());
        log.info(Log.FIND_VEHICLE, VehicleController.class.getName(), Log.M_FIND_VEHICLE, name, Log.END);
        return vehicles;
    }
}
