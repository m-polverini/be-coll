package com.carseller.cars.models;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class VehicleDTO {
    private int idVehicle;
    private String name;
    private String prodFrom;
    private String prodTo;
    private String line;
    private TypeVehicleDTO typeVehicle;
    private EngineDTO engine;
    private WheelDTO wheel;
    private VehicleDTO vehicleParent;
    private List<VehicleDTO> vehicles;
}
