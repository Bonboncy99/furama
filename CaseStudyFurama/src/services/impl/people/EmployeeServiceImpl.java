package services.impl.people;

import common.EnterPersonInformation;
import models.Person.Employee;
import services.IEmployeeService;
import util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements IEmployeeService {
    static Scanner scanner = new Scanner(System.in);
   public static final String FILE_EMPLOYEE_CSV = "src\\data\\people\\Employee.csv";

    @Override
    public void display() {
        List<Employee>employeeList = ReadAndWriteCSV.readEmployeeFromCSV(FILE_EMPLOYEE_CSV);
        for (int i = 0; i < employeeList.size(); i++) {
            System.out.println((i + 1) + ": " + employeeList.get(i));
        }
    }

    @Override
    public void add() {
        List<Employee>employeeList = new ArrayList<>();
        String name = EnterPersonInformation.enterName();
        LocalDate birthday = EnterPersonInformation.enterBirthday();
        String gender = EnterPersonInformation.createGender();
        String indentityNumber = EnterPersonInformation.enterEmployeeIdentity();
        String phone = EnterPersonInformation.enterPhone();
        String email = EnterPersonInformation.enterEmail();
        String employeeCode = EnterPersonInformation.enterEmployeeCode();
        String level = EnterPersonInformation.createLevel();
        String position = EnterPersonInformation.createPosition();
        double salary = Double.parseDouble(EnterPersonInformation.enterEmployeeSalary());

        Employee employee = new Employee(name, birthday, gender, indentityNumber, phone, email, employeeCode, level, position, salary);
        employeeList.add(employee);
        ReadAndWriteCSV.writeEmployeeToCSV(FILE_EMPLOYEE_CSV,employeeList,true);
        System.out.println("Đã thêm thành công: ");
        System.out.println(employee);

    }

    @Override
    public void update() {
        List<Employee>employeeList = ReadAndWriteCSV.readEmployeeFromCSV(FILE_EMPLOYEE_CSV);
        System.out.println("Nhập Mã nhân viên cần thay đổi");
        String employeeCode = scanner.nextLine();
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getEmployeeCode().equals(employeeCode)) {
                do {
                    System.out.println("Nhập thuộc tính cần thay đổi" +
                            "\n 1. Tên" +
                            "\n 2. Ngày sinh" +
                            "\n 3. Giới tính" +
                            "\n 4. Số cmnd" +
                            "\n 5. Điện thoại" +
                            "\n 6. Email" +
                            "\n 7. Trình Độ" +
                            "\n 8. Vị trí" +
                            "\n 9. Lương" +
                            "\n 10. Exit ");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            String name = EnterPersonInformation.enterName();
                            employeeList.get(i).setName(name);
                            break;
                        case "2":
                            LocalDate birthday = EnterPersonInformation.enterBirthday();
                            employeeList.get(i).setBirthday(birthday);
                            break;
                        case "3":
                            String gender = EnterPersonInformation.createGender();
                            employeeList.get(i).setGender(gender);
                            break;
                        case "4":
                            String indentityNumber = EnterPersonInformation.enterEmployeeIdentity();
                            employeeList.get(i).setIdentityNumber(indentityNumber);
                            break;
                        case "5":
                            String phone = EnterPersonInformation.enterPhone();
                            employeeList.get(i).setPhone(phone);
                            break;
                        case "6":
                            String email = EnterPersonInformation.enterEmail();
                            employeeList.get(i).setEmail(email);
                            break;
                        case "7":
                            String level = EnterPersonInformation.createLevel();
                            employeeList.get(i).setLevel(level);
                            break;
                        case "8":
                            String position = EnterPersonInformation.createPosition();
                            employeeList.get(i).setPosition(position);
                            break;
                        case "9":
                            double salary = Double.parseDouble(EnterPersonInformation.enterEmployeeSalary());
                            employeeList.get(i).setSalary(salary);
                            break;
                        case "10":
                            return;
                        default:
                            System.out.println("Nhập sai, chọn lại");
                    }
                } while (true);
            }
            ReadAndWriteCSV.writeEmployeeToCSV(FILE_EMPLOYEE_CSV,employeeList,false);
        }

    }
}
