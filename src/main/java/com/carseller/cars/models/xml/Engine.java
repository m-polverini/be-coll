package com.carseller.cars.models.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Engine {

    @XmlAttribute
    private Integer power;
    @XmlAttribute
    private String type;
}
