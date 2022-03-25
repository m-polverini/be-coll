package com.carseller.cars.repositories;

import com.carseller.cars.domain.TypeWheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeWheelRepository extends JpaRepository<TypeWheel, Integer> {

    @Query("select tw from TypeWheel tw where tw.typeWheel = :typeWheel and tw.active = true")
    public Optional<TypeWheel> findByType(@Param("typeWheel") String typeWheel);
}
