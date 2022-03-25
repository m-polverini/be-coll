package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class EngineDTO {
    private int idEngine;
    private int power;
    private boolean active;
    private TypeEngineDTO typeEngine;
}
