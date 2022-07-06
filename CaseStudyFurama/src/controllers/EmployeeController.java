package controllers;

import services.IEmployeeService;
import services.impl.people.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    private static Scanner scanner = new Scanner(System.in);
    private static IEmployeeService employeeService = new EmployeeServiceImpl();
    public static void displayEmployee() {
        do {
            System.out.println("Chọn chức năng" +
                    "\n 1 Display list employees" +
                    "\n 2 Add new employee" +
                    "\n 3 Edit employee" +
                    "\n 4 Return main menu");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Display list employees");
                    employeeService.display();
                    break;
                case "2":
                    System.out.println("Add new employee");
                    employeeService.add();
                    break;
                case "3":
                    System.out.println("Edit employee");
                    employeeService.update();
                    break;
                case "4":
                    return;
                default:
                    System.err.println("Nhập sai, chọn lại");
            }
        } while (true);
    }
}
