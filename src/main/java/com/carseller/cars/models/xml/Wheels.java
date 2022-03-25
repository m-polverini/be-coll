package com.carseller.cars.models.xml;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Wheels {

    @XmlAttribute
    private String size;
    @XmlAttribute
    private String type;
}
