package common;

import models.Facility.Facility;
import models.Person.Customer;
import util.ReadAndWriteCSV;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class GettingInfoToBooking {
    private static final String CUSTOMER_FILE_CSV = "src/data/people/Customer.csv";
    private static final String FACILITY_FILE_CSV = "src/data/Facility.csv";
    private static Scanner scanner = new Scanner(System.in);

    public static String getCustomerCode() {
        List<Customer> customerList = ReadAndWriteCSV.readCustomerFromCSV(CUSTOMER_FILE_CSV);
        for (Customer customer :customerList) {
            System.out.println(customer);
        }
        String customerCode;
        do {
            System.out.println("Chọn mã khách hàng");
            customerCode = scanner.nextLine();
            for (Customer customer : customerList) {
                if (customer.getCustomerCode().equals(customerCode)) {
                    return customerCode;
                }
            }
            System.out.println("Mã Khách hàng Không đúng, hãy chọn lại");
        } while (true);
    }


    public static String getServiceCode() {
        String serviceCode;
        Map<Facility, Integer> facilityIntegerMap = ReadAndWriteCSV.readFacilityFromCSV(FACILITY_FILE_CSV);
        Set<Facility> facilitySet = facilityIntegerMap.keySet();
        do {
            System.out.println("Chọn mã dịch vụ");
            serviceCode = scanner.nextLine();
            for (Facility facility : facilitySet) {
                if (facility.getServiceCode().equals(serviceCode)) {
                    return serviceCode;
                }
            }
            System.out.println("Mã dịch vụ không đúng, chọn lại");
        } while (true);

    }
}
