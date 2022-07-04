package services.impl;

import common.EnterFacilityInfo;
import models.Facility.Room;
import services.IRoomService;
import util.ReadAndWriteCSV;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class RoomServiceImpl implements IRoomService {
    private static final String FILE_ROOM_CSV = "src/data/Room.csv";

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
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        String serviceName = EnterFacilityInfo.enterServiceName();
        String usableArea = EnterFacilityInfo.enterUsableArea();
        String fee = EnterFacilityInfo.enterFee();
        String maxPeople = EnterFacilityInfo.enterMaxPeople();
        String rentalType = EnterFacilityInfo.chooseRentalType();
        String freeService = EnterFacilityInfo.enterFreeService();
        roomIntegerMap.put(new Room(serviceName, usableArea, fee, maxPeople, rentalType, freeService), 0);
        ReadAndWriteCSV.writeRoomtoCSV(FILE_ROOM_CSV, roomIntegerMap, true);
    }

    @Override
    public void update() {

    }

    public static void main(String[] args) {
        RoomServiceImpl roomService = new RoomServiceImpl();
        roomService.add();
        roomService.add();
        roomService.add();
        roomService.display();
    }
}
