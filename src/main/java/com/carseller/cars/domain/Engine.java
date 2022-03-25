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
@Table(name = "t_engine")
public class Engine implements Serializable {

    private static final long serialVersionUID = -9218796643738837130L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_engine", unique = true, nullable = false)
    private int idEngine;

    @Column(name = "power", nullable = false)
    private int power;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_engine")
    private TypeEngine typeEngine;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "engine")
    private List<Vehicle> vehicles = new ArrayList<>(0);

}
