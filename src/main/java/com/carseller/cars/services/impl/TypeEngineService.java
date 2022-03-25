package com.carseller.cars.services.impl;

import com.carseller.cars.domain.TypeEngine;
import com.carseller.cars.repositories.TypeEngineRepository;
import com.carseller.cars.services.ITypeEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class TypeEngineService implements ITypeEngineService {

    @Autowired
    private TypeEngineRepository typeEngineRepo;

    @Override
    public TypeEngine findOrSaveByDesc(String typeEngine) {
        Optional<TypeEngine> typeEngineOptional = typeEngineRepo.findByType(typeEngine);
        AtomicReference<TypeEngine> reference = new AtomicReference<>();
        reference.set(typeEngineOptional.orElseGet(() -> save(typeEngine)));
        return reference.get();
    }

    private TypeEngine save(String typeEngine) {
        TypeEngine tv = TypeEngine
                .builder()
                .typeEngine(typeEngine)
                .active(true)
                .build();
        return typeEngineRepo.save(tv);
    }
}
