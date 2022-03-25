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
@Table(name = "e_vehicle")
public class Vehicle implements Serializable {

    private static final long serialVersionUID = 6192768653019581615L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vehicle", unique = true, nullable = false)
    private int idVehicle;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "prod_from")
    private String prodFrom;

    @Column(name = "prod_to")
    private String prodTo;

    @Column(name = "line")
    private String line;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_vehicle")
    private TypeVehicle typeVehicle;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_engine")
    private Engine engine;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_wheel")
    private Wheel wheel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_vehicle_parent", referencedColumnName = "id_vehicle")
    private Vehicle vehicleParent;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "vehicleParent")
    private List<Vehicle> vehicles = new ArrayList<>(0);

}
