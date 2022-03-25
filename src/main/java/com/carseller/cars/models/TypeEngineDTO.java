package com.carseller.cars.models;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TypeEngineDTO {
    private int idTypeEngine;
    private String typeEngine;
    private boolean active;
}
