package com.carseller.cars.repositories;

import com.carseller.cars.domain.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    @Query("select v from Vehicle v where 1=1" +
            " and :name is null or :name = '' or UPPER(v.name) = UPPER(:name)")
    public List<Vehicle> findVehicle(@Param("name") String name);

    @Query("select v from Vehicle v where UPPER(v.name) = UPPER(:name)")
    public Optional<Vehicle> findByName(@Param("name") String name);
}
