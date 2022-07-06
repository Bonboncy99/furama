package models.Facility;

public class Villa extends Facility{
    private String roomStandard;
    private String poolArea;
    private String floor;

    public Villa() {
    }

    public Villa(String serviceCode, String serviceName, String usableArea, String fee, String maxPeople, String rentalType, String roomStandard, String poolArea, String floor) {
        super(serviceCode, serviceName, usableArea, fee, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+
                roomStandard + ","+
                poolArea + ","+
                floor;
    }
}
