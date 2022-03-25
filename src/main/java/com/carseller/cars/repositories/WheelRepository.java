package com.carseller.cars.repositories;

import com.carseller.cars.domain.Wheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WheelRepository extends JpaRepository<Wheel, Integer> {

    @Query("select w from Wheel w where w.sizeWheel.sizeWheel = :sizeWheel and w.typeWheel.typeWheel = :typeWheel and w.active = true")
    public Optional<Wheel> find(@Param("sizeWheel") String sizeWheel, @Param("typeWheel") String typeWheel);
}
