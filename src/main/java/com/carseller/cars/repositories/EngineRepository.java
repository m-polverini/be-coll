package com.carseller.cars.repositories;

import com.carseller.cars.domain.Engine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EngineRepository extends JpaRepository<Engine, Integer> {

    @Query("select e from Engine e where e.power = :power and e.typeEngine.typeEngine = :typeEngine and e.active = true")
    public Optional<Engine> find(@Param("power") int power, @Param("typeEngine") String typeEngine);
}
