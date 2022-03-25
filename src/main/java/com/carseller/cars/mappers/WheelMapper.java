package com.carseller.cars.mappers;

import com.carseller.cars.domain.Wheel;
import com.carseller.cars.models.WheelDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {SizeWheelMapper.class, TypeWheelMapper.class})
public interface WheelMapper {
    WheelMapper INSTANCE = Mappers.getMapper(WheelMapper.class);

    @Mapping(target = "vehicles", ignore = true)
    Wheel dtoToEntity(WheelDTO dto);

    WheelDTO entityToDto(Wheel entity);
}
