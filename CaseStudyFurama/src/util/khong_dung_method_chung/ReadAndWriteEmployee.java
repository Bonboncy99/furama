package util.khong_dung_method_chung;

import models.Person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteEmployee {
    public static void writeToFile(String path, List<Employee> employeeList, boolean append){
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Employee employee:employeeList) {
                bufferedWriter.write(employee.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Employee> readEmployeeFromCSV (String path){
        List <Employee> employeeList = new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null) {
                String[]arr = line.split(",");
                employeeList.add(new Employee(arr[0], LocalDate.parse(arr[1]),arr[2],arr[3],
                        arr[4],arr[5],arr[6],arr[7],arr[8],Double.parseDouble(arr[9])));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return employeeList;
    }
}
