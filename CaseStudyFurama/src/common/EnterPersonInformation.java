package common;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class EnterPersonInformation {
    static Scanner scanner = new Scanner(System.in);

    public static String enterName() {
        String name;
        do {
            System.out.println("Nhập tên (các từ đều phải Viết Hoa chữ cái đầu)");
            name = scanner.nextLine();
            if (PeopleChecking.checkRegexName(name)) {
                return name;
            } else {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static LocalDate enterBirthday() {
        LocalDate birthday;
        do {
            try {
                System.out.println("Nhập ngày sinh(dd/MM/yyyy)");
                birthday = LocalDate.parse(scanner.nextLine(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int age = birthday.until(LocalDate.now()).getYears();
                System.out.println(age);
                if (age >18 && age<100){
                    return birthday;
                }
            } catch (DateTimeParseException e){
                System.err.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static String createGender() {
        Scanner scanner = new Scanner(System.in);
        String gender="";
        do {
            System.out.println("Chọn giới tính" +
                    "\n 1.female" +
                    "\n 2.male" +
                    "\n 3.other");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    gender = "Female";
                    break;
                case "2":
                    gender = "Male";
                    break;
                case "3":
                    gender = "Other";
                    break;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (gender.equals(""));
        return gender;
    }

    public static String enterEmployeeIdentity(){
        String employeeIdentity;
        do {
            System.out.println("Nhập số CMND của nhân viên (9 chữ số)");
            employeeIdentity = scanner.nextLine();
            if (!PeopleChecking.checkRegexIdentity(employeeIdentity)){
                System.err.println("Nhập sai định dạng");
            } else if (PeopleChecking.checkEmployeeIdentity(employeeIdentity)){
                System.err.println("Số CMND đã tồn tại");
            }
            else {
                return employeeIdentity;
            }
        } while (true);
    }

    public static String enterCustomerIdentity(){
        String customerIdentity;
        do {
            System.out.println("Nhập số CMND của khách hàng (9 chữ số)");
            customerIdentity = scanner.nextLine();
            if (PeopleChecking.checkCustomerIdentity(customerIdentity)){
                System.err.println("Số CMND đã tồn tại");
            } else if (!PeopleChecking.checkRegexIdentity(customerIdentity)){
                System.err.println("Nhập sai định dạng");
            }
            else {
                return customerIdentity;
            }
        } while (true);
    }

    public static String enterPhone() {
        String phone;
        do {
            System.out.println("Nhập số điện thoại (0/84)XXXXXXXXX");
            phone = scanner.nextLine();
            if (PeopleChecking.checkRegexPhone(phone)) {
                return phone;
            } else {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static String enterEmail() {
        String email;
        do {
            System.out.println("Nhập email(xxxx@xxx.xx)");
            email = scanner.nextLine();
            if (PeopleChecking.checkRegexEmail(email)) {
                return email;
            } else {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static String createPosition() {
        String position = "";
        do {
            System.out.println("Chọn vị trí" +
                    "\n 1.Lễ tân" +
                    "\n 2.Phục vụ" +
                    "\n 3.Chuyên viên" +
                    "\n 4.Giám sát" +
                    "\n 5.Quản lý" +
                    "\n 6.Giám đốc");
            String choice =scanner.nextLine();
            switch (choice) {
                case "1":
                    position = "Lễ tân";
                    break;
                case "2":
                    position = "Phục vụ";
                    break;
                case "3":
                    position = "Chuyên viên";
                    break;
                case "4":
                    position = "Giám sát";
                    break;
                case "5":
                    position = "Quản lý";
                    break;
                case "6":
                    position = "Giám đốc";
                    break;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (position.equals(""));
        return position;
    }

    public static String createLevel() {
        Scanner scanner = new Scanner(System.in);
        String level = "";
        do {
            System.out.println("Chọn trình độ" +
                    "\n 1.Trung cấp" +
                    "\n 2.Cao đẳng" +
                    "\n 3.Đại học" +
                    "\n 3.Sau đại học");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    level = "Trung cấp";
                    break;
                case "2":
                    level = "Cao đẳng";
                    break;
                case "3":
                    level = "Đại học";
                    break;
                case "4":
                    level = "Sau đại học";
                    break;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (level.equals(""));
        return level;
    }

    public static String createCustomertype() {
        String customerType = "";
        do {
            System.out.println("Chọn loại khách hàng" +
                    "\n 1. Diamond" +
                    "\n 2. Platinium" +
                    "\n 3. Gold" +
                    "\n 4. Silver" +
                    "\n 5. Member");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    customerType = "Diamond";
                    break;
                case "2":
                    customerType = "Platinium";
                    break;
                case "3":
                    customerType = "Gold";
                    break;
                case "4":
                    customerType = "Silver";
                    break;
                case "5":
                    customerType = "Member";
                    break;
                default:
                    System.err.println("Chọn sai, nhập lại");
            }
        } while (customerType.equals(""));
        return customerType;
    }

    public static String enterEmployeeSalary() {
        String salary;
        do {
            System.out.println("Nhập lương (Số thực >0)");
            salary = scanner.nextLine();
            if (PeopleChecking.checkEmployeeSalary(salary)) {
                return salary;
            } else {
                System.out.println("Nhập sai định dạng");
            }
        } while (true);
    }

    public static String enterEmployeeCode() {
        String employeeCode;
        do {
            System.out.println("Nhập mã nhân viên (EMXXXX,X: số, không giới hạn số lượng X))");
            employeeCode =scanner.nextLine();
            if (!PeopleChecking.checkRegexEmployeeCode(employeeCode)){
                System.out.println("Nhập sai định dạng");
            } else if (PeopleChecking.checkEmployeeCode(employeeCode)){
                System.out.println("Mã nhân viên đã tồn tại");
            } else {
                return employeeCode;
            }
        }while (true);
    }

    public static String enterCustomerCode() {
        String customerCode;
        do {
            System.out.println("Nhập mã khách hàng (CUXXXX,X: số, không giới hạn số lượng X))");
            customerCode =scanner.nextLine();
            if (!PeopleChecking.checkRegexCustomerCode(customerCode)){
                System.out.println("Nhập sai định dạng");
            } else if (PeopleChecking.checkCustomerCode(customerCode)){
                System.out.println("Mã nhân viên đã tồn tại");
            } else {
                return customerCode;
            }
        }while (true);
    }

    public static String enterAddress(){
        System.out.println("Nhập địa chỉ khách hàng");
//        String address = scanner.nextLine();
        return scanner.nextLine();
    }

//    public static LocalDate createBirthDay (){
//        LocalDate date;
//        do {
//            date = enterBirthday();
//            if (PeopleChecking.checkBirthday(date)){
//                return date;
//            }else {
//                System.err.println("Tuổi phải từ 18-100");
//            }
//        } while (true);
//    }
//

}
