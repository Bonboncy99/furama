package models.Facility;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(String serviceName, String usableArea, String fee, String maxPeople, String rentalType, String freeService) {
        super(serviceName, usableArea, fee, maxPeople, rentalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                super.toString()+
                "freeService='" + freeService + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+
                freeService;
    }
}
