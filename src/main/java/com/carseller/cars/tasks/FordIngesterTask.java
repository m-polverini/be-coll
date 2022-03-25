package com.carseller.cars.tasks;

import com.carseller.cars.constants.Log;
import com.carseller.cars.exceptions.NoVehiclesFoundException;
import com.carseller.cars.mappers.ModelMapper;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.models.xml.Catalogue;
import com.carseller.cars.models.xml.Model;
import com.carseller.cars.services.IVehicleService;
import com.carseller.cars.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
public class FordIngesterTask {

  @Autowired
  private IVehicleService iVehicleService;

  @Scheduled(cron = "${cars.ford.ingester.runCron}")
  public void ingestFile() throws JAXBException, IOException {
    log.info(Log.GENERICO, FordIngesterTask.class.getName(), Log.M_INGEST_FILE, Log.START);
    JAXBContext context = JAXBContext.newInstance(Catalogue.class);
    Unmarshaller unmarshaller = context.createUnmarshaller();
    Catalogue catalogue = (Catalogue)unmarshaller.unmarshal(new ClassPathResource("ford-example.xml").getInputStream());
    iVehicleService.ingestVehicles(readCatalogue(catalogue));
    log.info(Log.GENERICO, FordIngesterTask.class.getName(), Log.M_INGEST_FILE, Log.END);
  }

  private List<VehicleDTO> readCatalogue(Catalogue catalogue) {
    if(!Util.isFilled(catalogue) || !Util.isFilled(catalogue.getModels()))
      throw new NoVehiclesFoundException("No vehicles to process");

    return catalogue.getModels()
            .stream()
            .map(this::processModel)
            .collect(Collectors.toList());
  }

  private VehicleDTO processModel(Model model) {
    return ModelMapper.INSTANCE.modelToDto(model);
  }
}
