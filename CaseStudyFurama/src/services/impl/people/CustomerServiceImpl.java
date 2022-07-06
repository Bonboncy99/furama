package services.impl.people;

import common.EnterPersonInformation;
import models.Person.Customer;
import services.ICustomerService;
import util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements ICustomerService {
    static Scanner scanner = new Scanner(System.in);
    static private final String FILE_CUSTOMER_CSV = "src/data/people/Customer.csv";

    @Override
    public void display() {
        List<Customer> customerList = ReadAndWriteCSV.readCustomerFromCSV(FILE_CUSTOMER_CSV);
        for (Customer customer : customerList) {
            System.out.println(customer);
        }
    }

    @Override
    public void add() {
        List<Customer> customerList = new LinkedList<>();
        String name = EnterPersonInformation.enterName();
        LocalDate birthday = EnterPersonInformation.enterBirthday();
        String gender = EnterPersonInformation.createGender();
        String indentityNumber = EnterPersonInformation.enterCustomerIdentity();
        String phone = EnterPersonInformation.enterPhone();
        String email = EnterPersonInformation.enterEmail();
        String customerType = EnterPersonInformation.createCustomertype();
        String customerCode = EnterPersonInformation.enterCustomerCode();
        String address = EnterPersonInformation.enterAddress();
        Customer customer = new Customer(name, birthday, gender, indentityNumber, phone, email, customerType, customerCode, address);
        customerList.add(customer);
        ReadAndWriteCSV.writeCustomerToCSV(FILE_CUSTOMER_CSV, customerList, true);
        System.out.println("Đã thêm thành công: ");
        System.out.println(customer);

    }

    @Override
    public void update() {
        List<Customer> customerList = ReadAndWriteCSV.readCustomerFromCSV(FILE_CUSTOMER_CSV);
        System.out.println("Nhập mã khách hàng cần thay đổi");
        String customerCode = scanner.nextLine();
        for (Customer customer : customerList) {
            if (customer.getCustomerCode().equals(customerCode)) {
                do {
                    System.out.println("Chọn thuộc tính cần thay đổi" +
                            "\n 1. Tên Khách hàng" +
                            "\n 2. Ngày sinh Khách hàng" +
                            "\n 3. Giới tính Khách hàng" +
                            "\n 4. Số cmnd Khách hàng" +
                            "\n 5. Số điện thoại Khách hàng" +
                            "\n 6. Email Khách hàng" +
                            "\n 7. Loại Khách hàng" +
                            "\n 8. Địa chỉ Khách hàng" +
                            "\n 9. Thoát");
                    String choice = scanner.nextLine();
                    switch (choice) {
                        case "1":
                            String name = EnterPersonInformation.enterName();
                            customer.setName(name);
                            break;
                        case "2":
                            LocalDate birthday = EnterPersonInformation.enterBirthday();
                            customer.setBirthday(birthday);
                            break;
                        case "3":
                            String gender = EnterPersonInformation.createGender();
                            customer.setGender(gender);
                            break;
                        case "4":
                            String indentityNumber = EnterPersonInformation.enterCustomerIdentity();
                            customer.setIdentityNumber(indentityNumber);
                            break;
                        case "5":
                            String phone = EnterPersonInformation.enterPhone();
                            customer.setPhone(phone);
                            break;
                        case "6":
                            String email = EnterPersonInformation.enterEmail();
                            customer.setEmail(email);
                            break;
                        case "7":
                            String customerType = EnterPersonInformation.createCustomertype();
                            customer.setCustomerType(customerType);
                            break;
                        case "8":
                            String address = EnterPersonInformation.enterAddress();
                            customer.setAddress(address);
                            break;
                        case "9":
                            return;
                        default:
                            System.err.println("Nhập sai,chọn lại");
                    }
                    ReadAndWriteCSV.writeCustomerToCSV(FILE_CUSTOMER_CSV, customerList, false);
                } while (true);
            }
        }
    }
}
