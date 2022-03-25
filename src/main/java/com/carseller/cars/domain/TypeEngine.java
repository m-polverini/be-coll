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
@Table(name = "t_type_engine")
public class TypeEngine implements Serializable {

    private static final long serialVersionUID = 6619334075486385186L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_type_engine", unique = true, nullable = false)
    private int idTypeEngine;

    @Column(name = "type_engine", nullable = false)
    private String typeEngine;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "typeEngine")
    private List<Engine> engines = new ArrayList<>(0);

}
