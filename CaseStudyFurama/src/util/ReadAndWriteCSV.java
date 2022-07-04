package util;

import models.Facility.House;
import models.Facility.Room;
import models.Facility.Villa;
import models.Person.Customer;
import models.Person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.*;

public class ReadAndWriteCSV {
    //Read and write String
    public static void writeStringToCSV(String path, List<String> stringList, boolean append) {
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (String string : stringList) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<String> readStringFromCSV(String path) {
        List<String> stringList = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;
        String line;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                stringList.add(line);
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringList;
    }


    //Read and write Employee (ArrayList)
    public static void writeEmployeeToCSV(String path, List<Employee> employeeList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Employee employee : employeeList) {
            stringList.add(employee.getInfoToCSV());
        }
        writeStringToCSV(path, stringList, append);
    }

    public static List<Employee> readEmployeeFromCSV(String path) {
        List<String> stringList = ReadAndWriteCSV.readStringFromCSV(path);
        List<Employee> employeeList = new ArrayList<>();
        for (String string : stringList) {
            String[] arr = string.split(",");
            employeeList.add(new Employee(arr[0], LocalDate.parse(arr[1]), arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8], Double.parseDouble(arr[9])));
        }
        return employeeList;
    }

    //    read and write Customer(LinkedList)
    public static void writeCustomerToCSV(String path, List<Customer> customerList, boolean append) {
        List<String> stringList = new ArrayList<>();
        for (Customer customer : customerList) {
            stringList.add(customer.getInfoToCSV());
        }
        writeStringToCSV(path, stringList, append);
    }

    public static List<Customer> readCustomerFromCSV(String path) {
        List<String> stringList = readStringFromCSV(path);
        List<Customer> customerList = new ArrayList<>();
        for (String str : stringList) {
            String[] arr = str.split(",");
            customerList.add(new Customer(arr[0], LocalDate.parse(arr[1]), arr[2], arr[3], arr[4], arr[5], arr[6], arr[7], arr[8]));
        }
        return customerList;
    }


    //read and write Villa (map)
    public static void writeVillatoCSV(String path, Map<Villa, Integer> villaIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Villa> villaSet = villaIntegerMap.keySet();
        for (Villa villa : villaSet) {
            stringList.add(villa.getInfoToCSV() + "," + 0);
        }
        writeStringToCSV(path, stringList, append);
    }

    public static Map<Villa, Integer> readVillaFromCSV(String path) {
        List<String> stringList = readStringFromCSV(path);
        Map<Villa, Integer> villaIntegerMap = new LinkedHashMap<>();
        for (String str : stringList) {
            String[] arr = str.split(",");
            villaIntegerMap.put(new Villa(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]), Integer.parseInt(arr[8]));
        }
        return villaIntegerMap;
    }


    //read and write house (map)
    public static void writeHousetoCSV(String path, Map<House, Integer> houseIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<House> houseSet = houseIntegerMap.keySet();
        for (House house : houseSet) {
            stringList.add(house.getInfoToCSV() + "," + 0);
        }
        writeStringToCSV(path, stringList, append);
    }

    public static Map<House, Integer> readHouseFromCSV(String path) {
        List<String> stringList = readStringFromCSV(path);
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        for (String str : stringList) {
            String[] arr = str.split(",");
            houseIntegerMap.put(new House(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]), Integer.parseInt(arr[7]));
        }
        return houseIntegerMap;
    }


    //read and write room(map)
    public static void writeRoomtoCSV(String path, Map<Room, Integer> roomIntegerMap, boolean append) {
        List<String> stringList = new ArrayList<>();
        Set<Room> roomSet = roomIntegerMap.keySet();
        for (Room room : roomSet) {
            stringList.add(room.getInfoToCSV() + "," + 0);
        }
        writeStringToCSV(path, stringList, append);
    }

    public static Map<Room, Integer> readRoomFromCSV(String path) {
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        List<String> stringList = readStringFromCSV(path);
        for (String str:stringList) {
            String[]arr = str.split(",");
            roomIntegerMap.put(new Room(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5]),Integer.parseInt(arr[6]));
        }
        return roomIntegerMap;
    }

}
