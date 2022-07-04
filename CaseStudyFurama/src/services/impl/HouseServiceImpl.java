package services.impl;

import common.EnterFacilityInfo;
import models.Facility.House;
import services.IHouseService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HouseServiceImpl implements IHouseService {
    private static final String FILE_HOUSE_CSV = "src/data/House.csv";

    @Override
    public void display() {
        Map<House, Integer> houseIntegerMap = ReadAndWriteCSV.readHouseFromCSV(FILE_HOUSE_CSV);
        Set<House> houseSet = houseIntegerMap.keySet();
        for (House house : houseSet) {
            System.out.println(house + ": " + houseIntegerMap.get(house));
        }
    }

    @Override
    public void add() {
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String roomStandard = EnterFacilityInfo.enterRoomStandard();
        String floor = EnterFacilityInfo.enterFloor();
        houseIntegerMap.put(new House(serviceName, usableArea, fee, maxPeople, rentalType, roomStandard, floor), 0);
        ReadAndWriteCSV.writeHousetoCSV(FILE_HOUSE_CSV, houseIntegerMap, true);
    }

    @Override
    public void update() {
    }
}
