package services.impl;
import services.IFacilityService;
import services.IHouseService;
import services.IRoomService;
import services.IVillaService;
import java.util.Scanner;

public class FacilityServiceImpl implements IFacilityService {
    Scanner scanner = new Scanner(System.in);
    IVillaService villaService = new VillaServiceImpl();
    IHouseService houseService = new HouseServiceImpl();
    IRoomService roomService = new RoomServiceImpl();

    @Override
    public void display() {
        do {
            System.out.println("Chọn chức năng\n" +
                    "1. Display Villa\n" +
                    "2. Display House\n" +
                    "3. Display Room\n" +
                    "4. Back to menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Display Villa");
                    villaService.display();
                    break;
                case "2":
                    System.out.println("Display House");
                    houseService.display();
                    break;
                case "3":
                    System.out.println("Display Room");
                    roomService.display();
                    break;
                case "4":
                    return;
                default:
                    System.err.println("Chọn sai, nhập lại");

            }
        } while (true);
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
