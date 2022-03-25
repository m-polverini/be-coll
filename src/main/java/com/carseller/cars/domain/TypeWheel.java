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
@Table(name = "t_type_wheel")
public class TypeWheel implements Serializable {


    private static final long serialVersionUID = -4717257939314017998L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_wheel", unique = true, nullable = false)
    private int idTypeWheel;

    @Column(name = "type_wheel", nullable = false)
    private String typeWheel;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "typeWheel")
    private List<Wheel> wheels = new ArrayList<>(0);

}
