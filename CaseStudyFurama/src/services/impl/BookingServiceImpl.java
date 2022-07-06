package services.impl;

import common.GettingInfoToBooking;
import models.Booking;
import services.IBookingService;
import services.ICustomerService;
import services.IFacilityService;
import services.impl.facility.FacilityServiceImpl;
import services.impl.people.CustomerServiceImpl;
import util.ReadAndWriteCSV;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class BookingServiceImpl implements IBookingService {
    private Scanner scanner = new Scanner(System.in);
    private ICustomerService customerService = new CustomerServiceImpl();
    private IFacilityService facilityService = new FacilityServiceImpl();
    private final String FILE_BOOKING_CSV = "src/data/Booking.csv";
    @Override
    public void display() {
        Set<Booking>bookingSet = ReadAndWriteCSV.readBookingFromCSV(FILE_BOOKING_CSV);
        for (Booking booking:bookingSet) {
            System.out.println(booking);
        }
    }

    @Override
    public void add() {
        Set<Booking>bookingSet = new TreeSet<>();
        System.out.println("Nhập mã booking");
        String bookingCode = scanner.nextLine();

        LocalDate startDay;
        do {
            try {
                System.out.println("Nhập ngày bắt đầu");
                 startDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                 break;
            } catch (DateTimeParseException e){
                System.err.println("Nhập sai định dạng");
            }
        } while (true);

        LocalDate endDay;
        do {
            try {
                System.out.println("Nhập ngày kết thúc");
                endDay = LocalDate.parse(scanner.nextLine(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                break;
            } catch (DateTimeParseException e){
                System.err.println("Nhập sai định dạng");
            }
        } while (true);

        String customerCode= GettingInfoToBooking.getCustomerCode();

        String serviceCode = GettingInfoToBooking.getServiceCode();

        System.out.println("Nhập loại dịch vụ");
        String serviceType = scanner.nextLine();

        bookingSet.add(new Booking(bookingCode,startDay,endDay,customerCode,serviceCode,serviceType));
        ReadAndWriteCSV.writeBookingToCSV(FILE_BOOKING_CSV,bookingSet,true);
    }

    @Override
    public void update() {

    }
}
