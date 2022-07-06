package util.khong_dung_method_chung;

import models.Facility.Villa;

import java.io.*;
import java.util.*;

public class ReadAndWriteVilla {
    public static void writeToCSV(String path, Map<Villa, Integer> villaIntegerMap, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Villa> villaSet = villaIntegerMap.keySet();
            for (Villa villa : villaSet) {
                bufferedWriter.write(villa.getInfoToCSV() + "," + villaIntegerMap.get(villa));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Villa,Integer> readFromCSV(String path) {
        Map<Villa,Integer> villaIntegerMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                Villa villa = new Villa(arr[0],arr[1],arr[2],arr[3],arr[4],arr[5],arr[6],arr[7],arr[8]);
                villaIntegerMap.put(villa,Integer.parseInt(arr[9]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return villaIntegerMap;
    }
}
