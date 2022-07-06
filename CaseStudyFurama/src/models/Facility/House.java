package models.Facility;

public class House extends Facility{
    private String roomStandard;
    private String floor;

    public House() {
    }

    public House(String serviceCode, String serviceName, String usableArea, String fee, String maxPeople, String rentalType, String roomStandard, String floor) {
        super(serviceCode, serviceName, usableArea, fee, maxPeople, rentalType);
        this.roomStandard = roomStandard;
        this.floor = floor;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getFloor() {
        return floor;
    }

    public void setFloor(String floor) {
        this.floor = floor;
    }

    @Override
    public String toString() {
        return "House{" +
                super.toString()+
                "roomStandard='" + roomStandard + '\'' +
                ", floor=" + floor +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV()+
                roomStandard +","+
                floor;
    }
}
