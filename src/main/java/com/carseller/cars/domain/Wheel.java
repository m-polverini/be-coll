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
@Table(name = "t_wheel")
public class Wheel implements Serializable {

    private static final long serialVersionUID = -9218796643738837130L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_wheel", unique = true, nullable = false)
    private int idWheel;

    @Column(name = "active", nullable = false)
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_type_wheel")
    private TypeWheel typeWheel;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_size_wheel")
    private SizeWheel sizeWheel;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "wheel")
    private List<Vehicle> vehicles = new ArrayList<>(0);

}
