package util.khong_dung_method_chung;

import models.Facility.House;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteHouse {
    public static void writeToCSV(String path, Map<House, Integer> houseIntegerMap, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<House> houseSet = houseIntegerMap.keySet();
            for (House house : houseSet) {
                bufferedWriter.write(house.getInfoToCSV() + "," + houseIntegerMap.get(house));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<House, Integer> readFromCSV(String path) {
        Map<House, Integer> houseIntegerMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                houseIntegerMap.put(new House(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6], arr[7]), Integer.parseInt(arr[8]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return houseIntegerMap;
    }

}
