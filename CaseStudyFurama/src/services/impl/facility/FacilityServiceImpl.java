package services.impl.facility;

import models.Facility.Facility;
import services.IFacilityService;
import services.IHouseService;
import services.IRoomService;
import services.IVillaService;
import util.ReadAndWriteCSV;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FacilityServiceImpl implements IFacilityService {
    private Scanner scanner = new Scanner(System.in);
    private IVillaService villaService = new VillaServiceImpl();
    private IHouseService houseService = new HouseServiceImpl();
    private IRoomService roomService = new RoomServiceImpl();
    private final String FILE_FACILITY_CSV = "src/data/Facility.csv";

    @Override
    public void display() {
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteCSV.readFacilityFromCSV(FILE_FACILITY_CSV);
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        for (Facility facility : facilitySet) {
            System.out.println(facility);
        }
    }

    @Override
    public void add() {
        do {
            System.out.println("Chọn chức năng \n" +
                    "1. Add New Villa\n" +
                    "2. Add New House\n" +
                    "3. Add New Room\n" +
                    "4. Back to menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Add New Villa");
                    villaService.add();
                    break;
                case "2":
                    System.out.println("Add New House");
                    houseService.add();
                    break;
                case "3":
                    System.out.println("Add New Room");
                    roomService.add();
                    break;
                case "4":
                    return;
                default:
                    System.err.println("Nhập sai, chọn lại");
            }
        } while (true);
    }

    @Override
    public void update() {

    }
}
