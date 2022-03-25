package com.carseller.cars.mappers;

import com.carseller.cars.domain.TypeVehicle;
import com.carseller.cars.models.TypeVehicleDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeVehicleMapper {
    TypeVehicleMapper INSTANCE = Mappers.getMapper(TypeVehicleMapper.class);

    @Mapping(target = "vehicles", ignore = true)
    TypeVehicle dtoToEntity(TypeVehicleDTO dto);

    TypeVehicleDTO entityToDto(TypeVehicle entity);
}
