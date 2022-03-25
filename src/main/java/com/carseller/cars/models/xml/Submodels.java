package com.carseller.cars.models.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Submodels {

    @XmlElement(name = "MODEL")
    private List<Model> models;
}
