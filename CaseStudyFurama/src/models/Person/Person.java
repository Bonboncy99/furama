package models.Person;

import java.time.LocalDate;
import java.util.Objects;
import java.util.Scanner;

public abstract class Person {
    private String name;
    private LocalDate birthday;
    private String gender;
    private String identityNumber;
    private String phone;
    private String email;

    public Person() {
    }

    public Person(String name, LocalDate birthday, String gender, String identityNumber, String phone, String email) {
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.identityNumber = identityNumber;
        this.phone = phone;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", gender='" + gender + '\'' +
                ", identityNumber='" + identityNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ",";
    }

    public String getInfoToCSV(){
        return this.getName() + ","+
                this.getBirthday()+","+
                this.getGender()+","+
                this.getIdentityNumber()+","+
                this.getPhone()+","+
                this.getEmail()+",";
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && Objects.equals(identityNumber, person.identityNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, identityNumber);
    }

}
