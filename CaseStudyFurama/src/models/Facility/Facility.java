package models.Facility;

public abstract class Facility {
    private String serviceCode;
    private String serviceName;
    private String usableArea;
    private String fee;
    private String maxPeople;
    private String rentalType;

    public Facility() {
    }

    public Facility(String serviceCode, String serviceName, String usableArea, String fee, String maxPeople, String rentalType) {
        this.serviceCode = serviceCode;
        this.serviceName = serviceName;
        this.usableArea = usableArea;
        this.fee = fee;
        this.maxPeople = maxPeople;
        this.rentalType = rentalType;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(String usableArea) {
        this.usableArea = usableArea;
    }

    public String getFee() {
        return fee;
    }

    public void setFee(String fee) {
        this.fee = fee;
    }

    public String getMaxPeople() {
        return maxPeople;
    }

    public void setMaxPeople(String maxPeople) {
        this.maxPeople = maxPeople;
    }

    public String getRentalType() {
        return rentalType;
    }

    public void setRentalType(String rentalType) {
        this.rentalType = rentalType;
    }

    @Override
    public String toString() {
        return "serviceCode='" + serviceCode + '\'' +
                ", serviceName='" + serviceName + '\'' +
                ", usableArea='" + usableArea + '\'' +
                ", fee='" + fee + '\'' +
                ", maxPeople='" + maxPeople + '\'' +
                ", rentalType='" + rentalType;
    }

    public  String getInfoToCSV(){
        return serviceCode+","+
                serviceName + ","+
                usableArea + ","+
                fee + ","+
                maxPeople + ","+
                rentalType + ",";
    }
}

