package com.carseller.cars.services.impl;

import com.carseller.cars.domain.SizeWheel;
import com.carseller.cars.repositories.SizeWheelRepository;
import com.carseller.cars.services.ISizeWheelService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicReference;

@Service
@Slf4j
public class SizeWheelService implements ISizeWheelService {

    @Autowired
    private SizeWheelRepository sizeWheelRepo;

    @Override
    public SizeWheel findOrSaveByDesc(String sizeWheel) {
        Optional<SizeWheel> sizeWheelOptional = sizeWheelRepo.findByType(sizeWheel);
        AtomicReference<SizeWheel> reference = new AtomicReference<>();
        reference.set(sizeWheelOptional.orElseGet(() -> save(sizeWheel)));
        return reference.get();
    }


    private SizeWheel save(String sizeWheel) {
        SizeWheel tv = SizeWheel
                .builder()
                .sizeWheel(sizeWheel)
                .active(true)
                .build();
        return sizeWheelRepo.save(tv);
    }

}
