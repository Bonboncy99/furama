package controllers;

import java.util.Scanner;

public class BookingController {
    public static void displayBooking() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chọn chức năng: " +
                    "\n 1. Add new booking" +
                    "\n 2. Display list booking" +
                    "\n 3. Create new constracts" +
                    "\n 4. Display list contracts" +
                    "\n 5. Edit contracts" +
                    "\n 6. Return main menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Add new booking");
                    break;
                case "2":
                    System.out.println("Display list booking");
                    break;
                case "3":
                    System.out.println("Create new constracts");
                    break;
                case "4":
                    System.out.println("Display list contracts");
                    break;
                case "5":
                    System.out.println("Edit contracts");
                    break;
                case "6":
                    return;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (true);
    }
}
