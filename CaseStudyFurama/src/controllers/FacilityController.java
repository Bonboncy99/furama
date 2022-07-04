package controllers;

import services.impl.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    public static void displayFacility() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chọn chức năng" +
                    "\n  1 Display list facility" +
                    "\n  2 Add new facility" +
                    "\n  3 Display list facility maintenance" +
                    "\n  4 Return main menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Display list facility");
                    facilityService.display();
                    break;
                case "2":
                    System.out.println("Add new facility");
                    facilityService.add();
                    break;
                case "3":
                    System.out.println("Display list facility maintenance");
                    break;
                case "4":
                   return;
                default:
                    System.err.println("Nhập sai, chọn lại");
            }
        } while (true);
    }
}
