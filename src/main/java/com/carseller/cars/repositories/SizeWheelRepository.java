package com.carseller.cars.repositories;

import com.carseller.cars.domain.SizeWheel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SizeWheelRepository extends JpaRepository<SizeWheel, Integer> {

    @Query("select sw from SizeWheel sw where sw.sizeWheel = :sizeWheel  and sw.active = true")
    public Optional<SizeWheel> findByType(@Param("sizeWheel") String sizeWheel);
}
