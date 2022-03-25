package com.carseller.cars.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_type_vehicle")
public class TypeVehicle implements Serializable {

    private static final long serialVersionUID = 5281457773132499240L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_vehicle", unique = true, nullable = false)
    private int idTypeVehicle;

    @Column(name = "type_vehicle", nullable = false)
    private String typeVehicle;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "typeVehicle")
    private List<Vehicle> vehicles = new ArrayList<>(0);

}
