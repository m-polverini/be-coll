package com.carseller.cars.repositories;

import com.carseller.cars.domain.TypeVehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeVehicleRepository extends JpaRepository<TypeVehicle, Integer> {

    @Query("select tv from TypeVehicle tv where tv.typeVehicle = :typeVehicle  and tv.active = true")
    public Optional<TypeVehicle> findByType(@Param("typeVehicle") String typeVehicle);
}
