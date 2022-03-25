package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class WheelDTO {
    private int idWheel;
    private boolean active;
    private TypeWheelDTO typeWheel;
    private SizeWheelDTO sizeWheel;
}
