package com.carseller.cars.models.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;


@Data
@XmlAccessorType(XmlAccessType.FIELD)
public class Model {

    @XmlAttribute
    private String name;
    @XmlAttribute
    private String from;
    @XmlAttribute
    private String to;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String line;
    @XmlElement(name = "ENGINE")
    private Engine engine;
    @XmlElement(name = "WHEELS")
    private Wheels wheels;
    @XmlElement(name = "SUBMODELS")
    private Submodels submodels;

}
