package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SizeWheelDTO {
    private int idSizeWheel;
    private String sizeWheel;
    private boolean active;
}
