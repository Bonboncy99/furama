package controllers;

import services.ICustomerService;
import services.impl.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
        public static void displayCustomer() {
            ICustomerService customerService =  new CustomerServiceImpl();
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Chọn chức năng: " +
                    "\n 1. Display list customers" +
                    "\n 2. Add new customer" +
                    "\n 3. Edit customer" +
                    "\n 4. Return main menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Display list customers");
                    customerService.display();
                    break;
                case "2":
                    System.out.println("Add new customer");
                    customerService.add();
                    break;
                case "3":
                    System.out.println("Edit customer");
                    break;
                case "4":
                   return;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (true);
    }

}
