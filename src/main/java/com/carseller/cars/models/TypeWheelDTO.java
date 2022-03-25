package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeWheelDTO {
    private int idTypeWheel;
    private String typeWheel;
    private boolean active;
}
