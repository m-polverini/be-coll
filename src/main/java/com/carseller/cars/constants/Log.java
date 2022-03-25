package com.carseller.cars.constants;

public class Log {

    private Log(){};

    public static final String START = "START";
    public static final String END = "END";

    public static final String FIND_VEHICLE_BY_ID = "{}.{}(idVehicle: {}) - {}";
    public static final String FIND_VEHICLE = "{}.{}(name: {}) - {}";
    public static final String INGEST_VEHICLES = "{}.{}(vehicles: {}) - {}";
    public static final String FIND_OR_SAVE_VEHICLE = "{}.{}(vehicle: {}) - {}";
    public static final String UPDATE_VEHICLE = "{}.{}(entity: {}, dto: {}) - {}";

    public static final String GENERICO = "{}.{}() - {}";

    //    METHODS
    public static final String M_FIND_VEHICLE_BY_ID="findVehicleById";
    public static final String M_FIND_VEHICLE="findVehicle";
    public static final String M_INGEST_FILE="ingestFile";
    public static final String M_INGEST_VEHICLES="ingestVehicles";
    public static final String M_FIND_OR_SAVE_VEHICLE="findOrSaveVehicle";
    public static final String M_UPDATE="update";
    public static final String M_SAVE="save";
    public static final String M_FIND_BY_ID="findById";


}
