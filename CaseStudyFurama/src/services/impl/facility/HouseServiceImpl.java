package services.impl.facility;

import common.EnterFacilityInfo;
import models.Facility.Facility;
import models.Facility.House;
import services.IHouseService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class HouseServiceImpl implements IHouseService {
    private static final String FILE_HOUSE_CSV = "src/data/House.csv";
    private final String FILE_FACILITY_CSV = "src/data/Facility.csv";


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
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        String serviceCode = EnterFacilityInfo.enterServiceHouseCode();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String roomStandard = EnterFacilityInfo.enterRoomStandard();
        String floor = EnterFacilityInfo.enterFloor();
        facilityIntegerMap.put(new House(serviceCode,serviceName, usableArea, fee, maxPeople, rentalType, roomStandard, floor), 0);
        ReadAndWriteCSV.writeFacilityToCSV(FILE_FACILITY_CSV,facilityIntegerMap,true);
    }

    @Override
    public void update() {
    }
}
