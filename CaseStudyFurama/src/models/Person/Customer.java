package models.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Customer extends Person{
    private String customerType;
    private String customerCode;
    private String address;

    public Customer() {
    }

    public Customer(String name, LocalDate birthday, String gender, String identityNumber, String phone, String email, String customerType, String customerCode, String address) {
        super(name, birthday, gender, identityNumber, phone, email);
        this.customerType = customerType;
        this.customerCode = customerCode;
        this.address = address;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerCode, customer.customerCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), customerCode);
    }

    @Override
    public String toString() {
        return "Customer{" +
                super.toString()+
                "customerType='" + customerType + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+
                customerType + ","+
                customerCode + ","+
                address;
    }
}
