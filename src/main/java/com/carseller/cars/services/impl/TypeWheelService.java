package com.carseller.cars.services.impl;

import com.carseller.cars.domain.TypeWheel;
import com.carseller.cars.mappers.TypeWheelMapper;
import com.carseller.cars.models.TypeWheelDTO;
import com.carseller.cars.repositories.TypeWheelRepository;
import com.carseller.cars.services.ITypeWheelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class TypeWheelService implements ITypeWheelService {

    @Autowired
    private TypeWheelRepository typeWheelRepo;

    @Override
    public TypeWheel findOrSaveByDesc(String typeWheel) {
        Optional<TypeWheel> typeWheelOptional = typeWheelRepo.findByType(typeWheel);
        AtomicReference<TypeWheel> reference = new AtomicReference<>();
        reference.set(typeWheelOptional.orElseGet(() -> save(typeWheel)));
        return reference.get();
    }

    private TypeWheel save(String typeWheel) {
        TypeWheel tv = TypeWheel
                .builder()
                .typeWheel(typeWheel)
                .active(true)
                .build();
        return typeWheelRepo.save(tv);
    }
}
