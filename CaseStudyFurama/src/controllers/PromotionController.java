package controllers;

import java.util.Scanner;

public class PromotionController {
    public static void displayPromotion() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chọn chức năng: " +
                    "\n 1. Display list customers use service" +
                    "\n 2. Display list customers get voucher" +
                    "\n 3. Return main menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Display list customers use service");
                    break;
                case "2":
                    System.out.println("Display list customers get voucher");
                    break;
                case "3":
                    return;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (true);
    }
}
