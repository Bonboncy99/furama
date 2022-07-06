package util.khong_dung_method_chung;

import models.Person.Customer;
import models.Person.Employee;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReadAndWriteCustomer {
    public static void writeToCSV(String path, List<Customer>customerList,boolean append){
        File file = new File(path);
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(file,append);
            bufferedWriter = new BufferedWriter(fileWriter);
            for (Customer customer :customerList) {
                bufferedWriter.write(customer.getInfoToCSV());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Customer> readFromCSV(String path){
        List<Customer> customerList= new ArrayList<>();
        File file = new File(path);
        FileReader fileReader;
        BufferedReader bufferedReader;
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())!=null){
                String[] arr = line.split(",");
                customerList.add(new Customer(arr[0], LocalDate.parse(arr[1]),arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return customerList;
    }
}
