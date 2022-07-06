package common;

import models.Facility.Facility;
import util.ReadAndWriteCSV;

import java.util.Map;
import java.util.Set;

public class FacilityCheck {
    private static final String VILLA_SERVICE_CODE_REGEX = "^SVVL-[0-9]{4}$";
    private static final String HOUSE_SERVICE_CODE_REGEX = "^SVHO-[0-9]{4}$";
    private static final String ROOM_SERVICE_CODE_REGEX = "^SVRO-[0-9]{4}$";
    private static final String SERVICE_NAME_REGEX = "[A-Z][a-z]*(\\s[a-z]*)*";
    public static final String AREA_REGEX = "^[0-9]{2,}\\.?[0-9]*$";
    public static final String FEE_REGEX = "[0-9]+\\.?[0-9]*";
    public static final String MAX_PEOPLE_REGEX = "^[0-9]{1,2}$";
    public static final String FLOOR_REGEX = "^[0-9]+$";
    private static final String ROOM_STANDARD_REGEX = "[A-Z][a-z]*(\\s[a-z]*)*";
    private static final String FREE_SERVICE_REGEX = "[A-Z][a-z]*(\\s[a-z]*)*";

    public static final String FACILITY_FILE_CSV = "src/data/Facility.csv";


    public static boolean checkRegexVillaCode(String code) {
        return code.matches(VILLA_SERVICE_CODE_REGEX);
    }

    public static boolean checkRegexHouseCode(String code) {
        return code.matches(HOUSE_SERVICE_CODE_REGEX);
    }

    public static boolean checkRegexRoomCode(String code) {
        return code.matches(ROOM_SERVICE_CODE_REGEX);
    }

    public static boolean checkServiceCode(String code){
        Map<Facility,Integer>facilityIntegerMap = ReadAndWriteCSV.readFacilityFromCSV(FACILITY_FILE_CSV);
        Set<Facility>facilitySet = facilityIntegerMap.keySet();
        for (Facility facility:facilitySet) {
            if (facility.getServiceCode().equals(code)){
                return true;
            }
        }
        return false;
    }
    public static boolean checkServiceName(String name) {
        return name.matches(SERVICE_NAME_REGEX);
    }

    public static boolean checkArea(String area) {
        return (area.matches(AREA_REGEX) && Double.parseDouble(area) >= 30);
    }

    public static boolean checkFee(String fee) {
        return (fee.matches(FEE_REGEX) && Double.parseDouble(fee) > 0);
    }

    public static boolean checkPeople(String numberOfPeople) {
        return (numberOfPeople.matches(MAX_PEOPLE_REGEX) && Integer.parseInt(numberOfPeople) > 0 && Integer.parseInt(numberOfPeople) < 21);
    }

    public static boolean checkFloor(String floor) {
        return (floor.matches(FLOOR_REGEX) && Integer.parseInt(floor) > 0);
    }

    public static boolean checkRoomStandard(String roomStandard) {
        return roomStandard.matches(ROOM_STANDARD_REGEX);
    }

    public static boolean checkFreeService(String freeService) {
        return freeService.matches(FREE_SERVICE_REGEX);
    }


}
