package controllers;

import java.util.Scanner;
public class FuramaController {
    private static Scanner scanner = new Scanner(System.in);
    public static void displayMainMenu() {
        do {
            System.out.println("Chọn chức năng: " +
                    "\n 1. Employee Management" +
                    "\n 2. Customer Management" +
                    "\n 3. Facility Management" +
                    "\n 4. Booking Management" +
                    "\n 5. Promotion Management" +
                    "\n 6. Exit");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Employee Management");
                    EmployeeController.displayEmployee();
                    break;
                case "2":
                    System.out.println("Customer Management");
                    CustomerController.displayCustomer();
                    break;
                case "3":
                    System.out.println("Facility Management");
                    FacilityController.displayFacility();
                    break;
                case "4":
                    System.out.println("Booking Management");
                    BookingController.displayBooking();
                    break;
                case "5":
                    System.out.println("Promotion Management");
                    PromotionController.displayPromotion();
                    break;
                case "6":
                    System.exit(6);
                    break;
                default:
                    System.err.println("Chọn sai, nhập lại");
                    break;
            }
        } while (true);
    }
}
