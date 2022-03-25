package com.carseller.cars.models.xml;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.List;

@Data
@XmlRootElement(name = "CATALOGUE")
@XmlAccessorType(XmlAccessType.FIELD)
public class Catalogue {

    @XmlElement(name = "MODEL")
    List<Model> models;

}
