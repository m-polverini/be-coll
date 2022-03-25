package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeVehicleDTO {
    private int idTypeVehicle;
    private String typeVehicle;
    private boolean active;
}
