package com.carseller.cars.services.impl;

import com.carseller.cars.constants.Log;
import com.carseller.cars.domain.Vehicle;
import com.carseller.cars.exceptions.NoVehiclesFoundException;
import com.carseller.cars.mappers.VehicleMapper;
import com.carseller.cars.models.VehicleDTO;
import com.carseller.cars.repositories.VehicleRepository;
import com.carseller.cars.services.IEngineService;
import com.carseller.cars.services.ITypeVehicleService;
import com.carseller.cars.services.IVehicleService;
import com.carseller.cars.services.IWheelService;
import com.carseller.cars.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class VehicleService implements IVehicleService {

    @Autowired
    private VehicleRepository repo;

    @Autowired
    private ITypeVehicleService iTypeVehicleService;

    @Autowired
    private IEngineService iEngineService;

    @Autowired
    private IWheelService iWheelService;

    @Override
    @Transactional
    public List<VehicleDTO> ingestVehicles(List<VehicleDTO> vehicles) {
        log.info(Log.INGEST_VEHICLES, VehicleService.class.getName(), Log.M_INGEST_VEHICLES, vehicles, Log.START);
        List<VehicleDTO> result = VehicleMapper.INSTANCE.entityListToDtoList(vehicles
                .stream()
                .map(this::findOrSaveVehicle)
                .collect(Collectors.toList()));
        log.info(Log.INGEST_VEHICLES, VehicleService.class.getName(), Log.M_INGEST_VEHICLES, vehicles, Log.END);
        return result;
    }

    private Vehicle findOrSaveVehicle(VehicleDTO vehicle) {
        log.info(Log.FIND_OR_SAVE_VEHICLE, VehicleService.class.getName(), Log.M_FIND_OR_SAVE_VEHICLE, vehicle, Log.START);
        Optional<Vehicle> v = repo.findVehicle(vehicle.getName());
        if(v.isPresent())
            return update(v.get(), vehicle);
        return save(vehicle);
    }

    public VehicleDTO findById(int idVehicle) {
        log.info(Log.FIND_VEHICLE_BY_ID, VehicleService.class.getName(), Log.M_FIND_BY_ID, idVehicle, Log.START);
        Vehicle v = repo.findById(idVehicle).orElseThrow(() -> new NoVehiclesFoundException("No vehicle found"));
        log.info(Log.FIND_VEHICLE_BY_ID, VehicleService.class.getName(), Log.M_FIND_BY_ID, idVehicle, Log.END);
        return VehicleMapper.INSTANCE.entityToDto(v);
    }

    @Override
    public VehicleDTO findVehicle(String name) {
        log.info(Log.FIND_VEHICLE, VehicleService.class.getName(), Log.M_FIND_VEHICLE, name, Log.START);
        Vehicle v = repo.findVehicle(name).orElseThrow(() -> new NoVehiclesFoundException("No vehicle found"));
        log.info(Log.FIND_VEHICLE, VehicleService.class.getName(), Log.M_FIND_VEHICLE, name, Log.END);
        return VehicleMapper.INSTANCE.entityToDto(v);    }

    private Vehicle update(Vehicle v, VehicleDTO dto) {
        log.info(Log.UPDATE_VEHICLE, VehicleService.class.getName(), Log.M_UPDATE, v, dto, Log.START);
        v.setProdFrom(dto.getProdFrom());
        v.setProdTo(dto.getProdTo());
        v.setTypeVehicle(iTypeVehicleService.findOrSaveByDesc(dto.getTypeVehicle().getTypeVehicle()));
        v.setEngine(iEngineService.findOrSave(dto.getEngine().getPower(), dto.getEngine().getTypeEngine().getTypeEngine()));
        v.setWheel(iWheelService.findOrSave(dto.getWheel().getSizeWheel().getSizeWheel(), dto.getWheel().getTypeWheel().getTypeWheel()));
        v.setLine(dto.getLine());
        Vehicle saved = repo.save(v);
        if(Util.isFilled(dto.getVehicles())){
            dto.getVehicles().forEach(veh -> {
                Optional<Vehicle> entityOp = repo.findVehicle(veh.getName());
                if(entityOp.isPresent()) {
                    Vehicle e = entityOp.get();
                    e.setVehicleParent(saved);
                    e.setTypeVehicle(saved.getTypeVehicle());
                    e.setLine(veh.getLine());
                    e.setEngine(iEngineService.findOrSave(veh.getEngine().getPower(), veh.getEngine().getTypeEngine().getTypeEngine()));
                    e.setWheel(iWheelService.findOrSave(veh.getWheel().getSizeWheel().getSizeWheel(), veh.getWheel().getTypeWheel().getTypeWheel()));
                    repo.save(e);
                } else {
                    veh.setTypeVehicle(dto.getTypeVehicle());
                    Vehicle entity = createEntity(veh);
                    entity.setVehicleParent(saved);
                    repo.save(entity);
                }
            });
        }
        log.info(Log.UPDATE_VEHICLE, VehicleService.class.getName(), Log.M_UPDATE, v, dto, Log.END);
        return saved;
    }

    private Vehicle createEntity(VehicleDTO vehicle) {
        return Vehicle
                .builder()
                .typeVehicle(iTypeVehicleService.findOrSaveByDesc(vehicle.getTypeVehicle().getTypeVehicle()))
                .name(vehicle.getName())
                .engine(iEngineService.findOrSave(vehicle.getEngine().getPower(), vehicle.getEngine().getTypeEngine().getTypeEngine()))
                .prodFrom(vehicle.getProdFrom())
                .prodTo(vehicle.getProdTo())
                .line(vehicle.getLine())
                .wheel(iWheelService.findOrSave(vehicle.getWheel().getSizeWheel().getSizeWheel(), vehicle.getWheel().getTypeWheel().getTypeWheel()))
                .build();
    }

    private Vehicle save(VehicleDTO vehicle) {
        log.info(Log.FIND_OR_SAVE_VEHICLE, VehicleService.class.getName(), Log.M_SAVE, vehicle, Log.START);
        Vehicle saved = repo.save(createEntity(vehicle));
        if(Util.isFilled(vehicle.getVehicles())) {
            vehicle.getVehicles().forEach(v -> {
                v.setTypeVehicle(vehicle.getTypeVehicle());
                Vehicle entity = createEntity(v);
                entity.setVehicleParent(saved);
                repo.save(entity);
            });
        }
        log.info(Log.FIND_OR_SAVE_VEHICLE, VehicleService.class.getName(), Log.M_SAVE, vehicle, Log.END);
        return saved;
    }
}
