package services.impl.facility;

import common.EnterFacilityInfo;
import models.Facility.Facility;
import models.Facility.Villa;
import services.IVillaService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class VillaServiceImpl implements IVillaService {
    public static final String FILE_VILLA_CSV = "src/data/Village.csv";
    private static final String FILE_FACILITY_CSV = "src/data/Facility.csv";


    @Override
    public void display() {
        Map<Villa, Integer> villaIntegerMap = ReadAndWriteCSV.readVillaFromCSV(FILE_VILLA_CSV);
        Set<Villa> villaSet = villaIntegerMap.keySet();
        for (Villa villa : villaSet) {
            System.out.println(villa + ": " + villaIntegerMap.get(villa));
        }
    }

    @Override
    public void add() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap();
        String serviceCode = EnterFacilityInfo.enterServiceVillaCode();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String roomStandard = EnterFacilityInfo.enterRoomStandard();
        String poolArea = EnterFacilityInfo.enterPoolArea();
        String floor = EnterFacilityInfo.enterFloor();
        facilityIntegerMap.put(new Villa(serviceCode,serviceName, usableArea, fee, maxPeople, rentalType, roomStandard, poolArea, floor), 0);
        ReadAndWriteCSV.writeFacilityToCSV(FILE_FACILITY_CSV, facilityIntegerMap, true);
    }

    @Override
    public void update() {

    }
}