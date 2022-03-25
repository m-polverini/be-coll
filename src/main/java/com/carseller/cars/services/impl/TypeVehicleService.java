package com.carseller.cars.services.impl;

import com.carseller.cars.domain.TypeVehicle;
import com.carseller.cars.repositories.TypeVehicleRepository;
import com.carseller.cars.services.ITypeVehicleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class TypeVehicleService implements ITypeVehicleService {

    @Autowired
    private TypeVehicleRepository typeVehicleRepo;

    @Override
    public TypeVehicle findOrSaveByDesc(String typeVehicle) {
        Optional<TypeVehicle> typeVehicleOptional = typeVehicleRepo.findByType(typeVehicle);
        AtomicReference<TypeVehicle> reference = new AtomicReference<>();
        reference.set(typeVehicleOptional.orElseGet(() -> save(typeVehicle)));
        return reference.get();
    }


    private TypeVehicle save(String typeVehicle) {
        TypeVehicle tv = TypeVehicle
                .builder()
                .typeVehicle(typeVehicle)
                .active(true)
                .build();
        return typeVehicleRepo.save(tv);
    }
}
