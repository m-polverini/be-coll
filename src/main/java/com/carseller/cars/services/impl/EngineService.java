package com.carseller.cars.services.impl;

import com.carseller.cars.domain.Engine;
import com.carseller.cars.repositories.EngineRepository;
import com.carseller.cars.services.IEngineService;
import com.carseller.cars.services.ITypeEngineService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class EngineService implements IEngineService {

    @Autowired
    private EngineRepository engineRepo;

    @Autowired
    private ITypeEngineService iTypeEngineService;

    @Override
    public Engine findOrSave(int power, String typeEngine) {
        Optional<Engine> engineOptional = engineRepo.find(power, typeEngine);
        AtomicReference<Engine> reference = new AtomicReference<>();
        reference.set(engineOptional.orElseGet(() -> save(power, typeEngine)));
        return reference.get();
    }

    private Engine save(int power, String typeEngine) {
        Engine tv = Engine
                .builder()
                .typeEngine(iTypeEngineService.findOrSaveByDesc(typeEngine))
                .power(power)
                .active(true)
                .build();
        return engineRepo.save(tv);
    }

}
