package com.carseller.cars.repositories;

import com.carseller.cars.domain.TypeEngine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TypeEngineRepository extends JpaRepository<TypeEngine, Integer> {

    @Query("select te from TypeEngine te where te.typeEngine = :typeEngine  and te.active = true")
    public Optional<TypeEngine> findByType(@Param("typeEngine") String typeEngine);
}
