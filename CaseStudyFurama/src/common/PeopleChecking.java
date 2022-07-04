package common;

import models.Person.Customer;
import models.Person.Employee;
import util.ReadAndWriteCSV;
import util.khong_dung_method_chung.ReadAndWriteCustomer;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

public class PeopleChecking {
    private static final String EMPLOYEE_FILE_CSV = "src/data/Employee.csv";
    private static final String CUSTOMER_FILE_CSV = "src/data/Customer.csv";

    private static final String NAME_REGEX = "^[A-Z][a-z]*(\\s[A-Z][a-z]*)*$";
    private static final String MAIL_REGEX = "^\\w+@[a-z]+\\.[a-z]+$";
    public static final String IDENTITY_REGEX = "^[0-9]{9}$";
    public static final String PHONE_REGEX = "^[0-9]{2}\\s*-\\s*[0-9]{10}$";
    public static final String EMPLOY_CODE_REGEX = "^EM[0-9]+$";
    public static final String CUSTOMER_CODE_REGEX = "^CU[0-9]+$";
    public static final String EMPLOY_SALARY_REGEX = "^[0-9]+\\.?[0-9]*$";

    public static boolean checkRegexName(String str) {
        return str.matches(NAME_REGEX);
    }
    public static boolean checkRegexEmail(String email) {
        return email.matches(MAIL_REGEX);
    }
    public static boolean checkRegexIdentity(String identity){ return identity.matches(IDENTITY_REGEX);}
    public static boolean checkRegexPhone(String phone){ return phone.matches(PHONE_REGEX);}
    public static boolean checkRegexEmployeeCode(String employeeCode){ return employeeCode.matches(EMPLOY_CODE_REGEX);}
    public static boolean checkRegexCustomerCode(String customerCode){ return customerCode.matches(CUSTOMER_CODE_REGEX);}
    public static boolean checkEmployeeSalary(String salary){return (salary.matches(EMPLOY_SALARY_REGEX)&&Double.parseDouble(salary)>0);}


    public static boolean checkEmployeeCode (String employeeCode){
        List<Employee>employeeList = ReadAndWriteCSV.readEmployeeFromCSV(EMPLOYEE_FILE_CSV);
        for (Employee employee:employeeList) {
            if (employee.getEmployeeCode().equals(employeeCode)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkEmployeeIdentity (String identity){
        List<Employee>employeeList = ReadAndWriteCSV.readEmployeeFromCSV(EMPLOYEE_FILE_CSV);
        for (Employee employee:employeeList) {
            if (employee.getIdentityNumber().equals(identity)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkCustomerCode(String customerCode){
        List<Customer>customerList = ReadAndWriteCustomer.readFromCSV(CUSTOMER_FILE_CSV);
        for (Customer customer:customerList) {
            if (customer.getCustomerCode().equals(customerCode)){
                return true;
            }
        }
        return false;
    }

    public static boolean checkCustomerIdentity(String customerIdentity){
        List<Customer>customerList = ReadAndWriteCustomer.readFromCSV(CUSTOMER_FILE_CSV);
        for (Customer customer:customerList) {
            if (customer.getIdentityNumber().equals(customerIdentity)){
                return true;
            }
        }
        return false;
    }


    public static boolean checkBirthday(LocalDate birthday){
        LocalDate now = LocalDate.now();
        int yearOfBirth = birthday.getYear();
        int age = Period.between(birthday, now).getYears();
        if (age<=100 && age>=18){
                System.out.println(age);
            return true;
        } else {
            System.out.println(age);
            return false;
        }
    }


}
