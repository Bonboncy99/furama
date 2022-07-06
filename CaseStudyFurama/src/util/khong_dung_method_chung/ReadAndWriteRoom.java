package util.khong_dung_method_chung;

import models.Facility.House;
import models.Facility.Room;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class ReadAndWriteRoom {
    public static void writeToCSV(String path, Map<Room, Integer> roomIntegerMap, boolean append) {
        File file = new File(path);
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(file, append);
            bufferedWriter = new BufferedWriter(fileWriter);
            Set<Room> roomSet = roomIntegerMap.keySet();
            for (Room room : roomSet) {
                bufferedWriter.write(room.getInfoToCSV() + "," + roomIntegerMap.get(room));
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Room, Integer> readFromCSV(String path) {
        Map<Room, Integer> roomIntegerMap = new LinkedHashMap<>();
        File file = new File(path);
        FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        String line = "";
        try {
            fileReader = new FileReader(file);
            bufferedReader = new BufferedReader(fileReader);
            while ((line = bufferedReader.readLine()) != null) {
                String[] arr = line.split(",");
                roomIntegerMap.put(new Room(arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], arr[6]), Integer.parseInt(arr[7]));
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return roomIntegerMap;
    }






}
