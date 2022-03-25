package com.carseller.cars.mappers;

import com.carseller.cars.domain.Engine;
import com.carseller.cars.models.EngineDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {TypeEngineMapper.class})
public interface EngineMapper {
    EngineMapper INSTANCE = Mappers.getMapper(EngineMapper.class);

    @Mapping(target = "vehicles", ignore = true)
    Engine dtoToEntity(EngineDTO dto);

    EngineDTO entityToDto(Engine entity);
}
