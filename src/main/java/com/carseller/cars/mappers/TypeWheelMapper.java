package com.carseller.cars.mappers;

import com.carseller.cars.domain.TypeWheel;
import com.carseller.cars.models.TypeWheelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {
    WheelMapper.class
})
public interface TypeWheelMapper {
    TypeWheelMapper INSTANCE = Mappers.getMapper(TypeWheelMapper.class);

    @Mapping(target = "wheels", ignore = true)
    TypeWheel dtoToEntity(TypeWheelDTO dto);

    TypeWheelDTO entityToDto(TypeWheel entity);
}
