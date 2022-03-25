package com.carseller.cars.mappers;

import com.carseller.cars.domain.SizeWheel;
import com.carseller.cars.models.SizeWheelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface SizeWheelMapper {
    SizeWheelMapper INSTANCE = Mappers.getMapper(SizeWheelMapper.class);

    @Mapping(target = "wheels", ignore = true)
    SizeWheel dtoToEntity(SizeWheelDTO dto);

    SizeWheelDTO entityToDto(SizeWheel entity);
}
