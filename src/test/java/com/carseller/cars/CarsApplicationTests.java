package com.carseller.cars;

import com.carseller.cars.exceptions.NoVehiclesFoundException;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.services.IVehicleService;
import com.carseller.cars.tasks.FordIngesterTask;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;
@Sql(scripts = "file:src/test/resources/delete.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "file:src/test/resources/insert.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
@Sql(scripts = "file:src/test/resources/delete.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
@RunWith(SpringRunner.class)
@SpringBootTest
public class CarsApplicationTests {

  @Autowired
  private IVehicleService vehicleService;

  @Autowired
  private FordIngesterTask ingesterTask;

  @Test
  @Transactional
  public void testIngest() throws JAXBException, IOException {
    ingesterTask.ingestFile();
    List<VehicleDTO> vehicles = vehicleService.findVehicle(null);
    Assertions.assertEquals(vehicles.size(), 5);
  }

  @Test
  @Transactional
  public void testFindById() throws JAXBException, IOException {
    VehicleDTO vehicle = vehicleService.findById(1);
    Assertions.assertEquals(vehicle.getName(), "Yaris");
  }

  @Test
  public void testFindByIdAndThrowNotFound() {
    Assert.assertThrows(NoVehiclesFoundException.class, () -> vehicleService.findById(9999));
  }

  @Test
  @Transactional
  public void testFindVehicle() throws JAXBException, IOException {
    List<VehicleDTO> vehicles = vehicleService.findVehicle("yaris");
    Assertions.assertEquals(vehicles.size(), 1);
  }
}
