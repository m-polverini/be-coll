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
@Table(name = "t_size_wheel")
public class SizeWheel implements Serializable {


    private static final long serialVersionUID = -50204393408823584L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_size_wheel", unique = true, nullable = false)
    private int idSizeWheel;

    @Column(name = "size_wheel", nullable = false)
    private String sizeWheel;

    @Column(name = "active", nullable = false)
    private boolean active;

    @Builder.Default
    @OneToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY, mappedBy = "sizeWheel")
    private List<Wheel> wheels = new ArrayList<>(0);

}
