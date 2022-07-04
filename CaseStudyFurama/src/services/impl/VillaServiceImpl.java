package services.impl;

import common.EnterFacilityInfo;
import models.Facility.Villa;
import services.IVillaService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class VillaServiceImpl implements IVillaService {
    public static final String FILE_VILLA_CSV = "src/data/Village.csv";

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
        Map<Villa, Integer> villaMap = new LinkedHashMap();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String roomStandard = EnterFacilityInfo.enterRoomStandard();
        String poolArea = EnterFacilityInfo.enterPoolArea();
        String floor = EnterFacilityInfo.enterFloor();
        villaMap.put(new Villa(serviceName, usableArea, fee, maxPeople, rentalType, roomStandard, poolArea, floor), 0);
        ReadAndWriteCSV.writeVillatoCSV(FILE_VILLA_CSV, villaMap, true);
    }

    @Override
    public void update() {

    }
}