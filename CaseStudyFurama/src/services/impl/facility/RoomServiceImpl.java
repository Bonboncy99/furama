package services.impl.facility;

import common.EnterFacilityInfo;
import models.Facility.Facility;
import models.Facility.Room;
import services.IRoomService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RoomServiceImpl implements IRoomService {
    private static final String FILE_ROOM_CSV = "src/data/Room.csv";
    private static final String FILE_FACILITY_CSV = "src/data/Facility.csv";


    @Override
    public void display() {
        Map<Room, Integer> roomIntegerMap = ReadAndWriteCSV.readRoomFromCSV(FILE_ROOM_CSV);
        Set<Room> roomSet = roomIntegerMap.keySet();
        for (Room room : roomSet) {
            System.out.println(room + ": " + roomIntegerMap.get(room));
        }

    }

    @Override
    public void add() {
        Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
        String serviceCode = EnterFacilityInfo.enterServiceRoomCode();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String freeService = EnterFacilityInfo.enterFreeService();
        facilityIntegerMap.put(new Room(serviceCode,serviceName, usableArea, fee, maxPeople, rentalType, freeService), 0);
        ReadAndWriteCSV.writeFacilityToCSV(FILE_FACILITY_CSV, facilityIntegerMap, true);
    }

    @Override
    public void update() {

    }

}
