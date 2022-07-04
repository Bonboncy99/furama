package models.Person;

import java.time.LocalDate;
import java.util.Objects;

public class Employee extends Person {
    private String employeeCode;
    private String level;
    private String position;
    private double salary;

    public Employee() {
    }

    public Employee(String name, LocalDate birthday, String gender, String identityNumber, String phone, String email, String employeeCode, String level, String position, double salary) {
        super(name, birthday, gender, identityNumber, phone, email);
        this.employeeCode = employeeCode;
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getEmployeeCode() {
        return employeeCode;
    }

    public void setEmployeeCode(String employeeCode) {
        this.employeeCode = employeeCode;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(employeeCode, employee.employeeCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), employeeCode);
    }

    @Override
    public String toString() {
        return "Employee{" +
                super.toString()+
                "employeeCode='" + employeeCode + '\'' +
                ", level='" + level + '\'' +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() +
                employeeCode + ","+
                level + ","+
                position + ","+
                salary;
    }
}
