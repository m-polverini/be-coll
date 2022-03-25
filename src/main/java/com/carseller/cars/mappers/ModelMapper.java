package com.carseller.cars.mappers;

import com.carseller.cars.domain.Wheel;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.models.WheelDTO;
import com.carseller.cars.models.xml.Model;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ModelMapper {
    ModelMapper INSTANCE = Mappers.getMapper(ModelMapper.class);

    @Mapping(source = "from", target = "prodFrom")
    @Mapping(source = "to", target = "prodTo")
    @Mapping(source = "type", target = "typeVehicle.typeVehicle")
    @Mapping(source = "engine.type", target = "engine.typeEngine.typeEngine")
    @Mapping(source = "wheels.size", target = "wheel.sizeWheel.sizeWheel")
    @Mapping(source = "wheels.type", target = "wheel.typeWheel.typeWheel")
    @Mapping(source = "submodels.models", target = "vehicles")
    VehicleDTO modelToDto(Model entity);
}
