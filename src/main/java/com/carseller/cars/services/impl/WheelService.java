package com.carseller.cars.services.impl;

import com.carseller.cars.domain.Engine;
import com.carseller.cars.domain.Wheel;
import com.carseller.cars.repositories.WheelRepository;
import com.carseller.cars.services.ISizeWheelService;
import com.carseller.cars.services.ITypeWheelService;
import com.carseller.cars.services.IWheelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class WheelService implements IWheelService {

    @Autowired
    private WheelRepository wheelRepo;

    @Autowired
    private ITypeWheelService iTypeWheelService;

    @Autowired
    private ISizeWheelService iSizeWheelService;

    @Override
    public Wheel findOrSave(String sizeWheel, String typeWheel) {
        Optional<Wheel> wheelOptional = wheelRepo.find(sizeWheel, typeWheel);
        AtomicReference<Wheel> reference = new AtomicReference<>();
        reference.set(wheelOptional.orElseGet(() -> save(sizeWheel, typeWheel)));
        return reference.get();
    }

    private Wheel save(String sizeWheel, String typeWheel) {
        Wheel w = Wheel
                .builder()
                .typeWheel(iTypeWheelService.findOrSaveByDesc(typeWheel))
                .sizeWheel(iSizeWheelService.findOrSaveByDesc(sizeWheel))
                .active(true)
                .build();
        return wheelRepo.save(w);
    }
}
