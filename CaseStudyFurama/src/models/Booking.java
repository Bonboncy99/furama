package models;

import java.time.LocalDate;
import java.util.Objects;

public class Booking implements Comparable<Booking> {
    private String bookingCode;
    private LocalDate startDay;
    private LocalDate endDay;
    private String customerCode;
   private String serviceCode;
    private String serviceType;

    public Booking() {
    }

    public Booking(String bookingCode, LocalDate startDay, LocalDate endDay, String customerCode, String serviceCode, String serviceType) {
        this.bookingCode = bookingCode;
        this.startDay = startDay;
        this.endDay = endDay;
        this.customerCode = customerCode;
        this.serviceCode = serviceCode;
        this.serviceType = serviceType;
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public LocalDate getStartDay() {
        return startDay;
    }

    public void setStartDay(LocalDate startDay) {
        this.startDay = startDay;
    }

    public LocalDate getEndDay() {
        return endDay;
    }

    public void setEndDay(LocalDate endDay) {
        this.endDay = endDay;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", startDay=" + startDay +
                ", endDay=" + endDay +
                ", customerCode='" + customerCode + '\'' +
                ", serviceCode='" + serviceCode + '\'' +
                ", serviceType='" + serviceType + '\'' +
                '}';
    }

    public String getInfoToCSV(){
        return bookingCode + ","+
                startDay + ","+
                endDay + ","+
                customerCode + ","+
                serviceCode + ","+
                serviceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(startDay, booking.startDay);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startDay);
    }

    @Override
    public int compareTo(Booking o) {
        if (this.startDay.compareTo(o.startDay) > 0) {
            return 1;
        } else if (this.startDay.compareTo(o.startDay) < 0) {
            return -1;
        } else {
            return this.endDay.compareTo(o.endDay);
        }
    }


}
