package com.carseller.cars.mappers;

import com.carseller.cars.domain.TypeEngine;
import com.carseller.cars.models.TypeEngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TypeEngineMapper {
    TypeEngineMapper INSTANCE = Mappers.getMapper(TypeEngineMapper.class);

    @Mapping(target = "engines", ignore = true)
    TypeEngine dtoToEntity(TypeEngineDTO dto);

    TypeEngineDTO entityToDto(TypeEngine entity);
}
