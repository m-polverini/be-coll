package com.carseller.cars.mappers;

import com.carseller.cars.domain.Vehicle;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.utils.Util;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(uses = {TypeVehicleMapper.class, EngineMapper.class, WheelMapper.class})
public interface VehicleMapper {
    VehicleMapper INSTANCE = Mappers.getMapper(VehicleMapper.class);

    Vehicle dtoToEntity(VehicleDTO dto);

    @Mapping(target = "vehicles", expression = "java(mapVehicles(entity))")
    VehicleDTO entityToDto(Vehicle entity);

    List<VehicleDTO> entityListToDtoList(List<Vehicle> entity);

    default List<VehicleDTO> mapVehicles(Vehicle entity) {
        if(!Util.isFilled(entity.getVehicleParent())) {
            if(Util.isFilled(entity.getVehicles())) {
                return entity.getVehicles().stream().map(vehicle -> {
                    vehicle.setVehicleParent(null);
                    return INSTANCE.entityToDto(vehicle);
                }).collect(Collectors.toList());
            }
        }
        return new ArrayList<>();
    }
}
