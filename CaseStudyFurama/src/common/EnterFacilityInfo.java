package common;

import java.util.Scanner;

public class EnterFacilityInfo {


//- Riêng loại Room sẽ có thêm thông tin: Dịch vụ miễn phí đi kèm.

    static Scanner scanner = new Scanner(System.in);

    public static String enterServiceVillaCode() {
        String serviceCode;
        do {
            System.out.println("Nhập tên dịch vụ (Mã dịch vụ phải đúng định dạng: SVVL-YYYY, với YYYY là các số từ 0-9,)");
            serviceCode = scanner.nextLine();
            if (!FacilityCheck.checkRegexVillaCode(serviceCode)) {
                System.out.println("Mã dịch vụ sai định dạng");
            }else if (FacilityCheck.checkServiceCode(serviceCode)){
                System.out.println("Mã dịch vụ đã tồn tại");
            } else {
                return serviceCode;
            }
        } while (true);
    }

    public static String enterServiceHouseCode() {
        String serviceCode;
        do {
            System.out.println("Nhập tên dịch vụ (Mã dịch vụ phải đúng định dạng: SVHO-YYYY, với YYYY là các số từ 0-9,)");
            serviceCode = scanner.nextLine();
            if (!FacilityCheck.checkRegexHouseCode(serviceCode)) {
                System.out.println("Mã dịch vụ sai định dạng");
            }else if (FacilityCheck.checkServiceCode(serviceCode)){
                System.out.println("Mã dịch vụ đã tồn tại");
            } else {
                return serviceCode;
            }
        } while (true);
    }

    public static String enterServiceRoomCode() {
        String serviceCode;
        do {
            System.out.println("Nhập tên dịch vụ (Mã dịch vụ phải đúng định dạng: SVRO-YYYY, với YYYY là các số từ 0-9,)");
            serviceCode = scanner.nextLine();
            if (!FacilityCheck.checkRegexRoomCode(serviceCode)) {
                System.out.println("Mã dịch vụ sai định dạng");
            }else if (FacilityCheck.checkServiceCode(serviceCode)){
                System.out.println("Mã dịch vụ đã tồn tại");
            } else {
                return serviceCode;
            }
        } while (true);
    }

    public static String enterServiceName() {
        String serviceName;
        do {
            System.out.println("Nhập tên dịch vụ (Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
            serviceName = scanner.nextLine();
            if (FacilityCheck.checkServiceName(serviceName)) {
                return serviceName;
            }
        } while (true);
    }

    public static String enterUsableArea() {
        String usableArea;
        do {
            System.out.println("Nhập Diện tích sử dụng (Diện tích sử dụng phải là số thực lớn hơn 30m2)");
            usableArea = scanner.nextLine();
            if (FacilityCheck.checkArea(usableArea)) {
                return usableArea;
            }
        } while (true);
    }

    public static String enterFee() {
        String fee;
        do {
            System.out.println("Nhập chi phí thuê (Chi phí thuê phải là số dương)");
            fee = scanner.nextLine();
            if (FacilityCheck.checkFee(fee)) {
                return fee;
            }
        } while (true);
    }

    public static String enterMaxPeople() {
        String maxPeople;
        do {
            System.out.println("Nhập số lượng người tối đa (số người tối đa phải lớn hơn 0 và nhỏ hơn 20");
            maxPeople = scanner.nextLine();
            if (FacilityCheck.checkPeople(maxPeople)) {
                return maxPeople;
            }
        } while (true);
    }

    public static String chooseRentalType() {
        String rentalType = "";
        do {
            System.out.println("Chọn kiểu thuê" +
                    "\n 1. Thuê theo năm" +
                    "\n 2. Thuê theo tháng" +
                    "\n 3. Thuê theo ngày" +
                    "\n 4. Thuê theo giờ");
            String choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    rentalType = "Thuê theo năm";
                    break;
                case "2":
                    rentalType = "Thuê theo tháng";
                    break;
                case "3":
                    rentalType = "Thuê theo ngày";
                    break;
                case "4":
                    rentalType = "Thuê theo giờ";
                    break;
                default:
                    System.err.println("Nhập sai, chọn lại");
            }
        } while (rentalType.equals(""));
        return rentalType;
    }

    public static String enterRoomStandard() {
        String roomStandard;
        do {
            System.out.println("Nhập tiêu chuẩn phòng (tiêu chuẩn phòng phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
            roomStandard = scanner.nextLine();
            if (FacilityCheck.checkRoomStandard(roomStandard)) {
                return roomStandard;
            }
        } while (true);
    }

    public static String enterPoolArea() {
        String poolArea;
        do {
            System.out.println("Nhập Diện tích hồ bơi (Diện tích hồ bơi phải là số thực lớn hơn 30m2)");
            poolArea = scanner.nextLine();
            if (FacilityCheck.checkArea(poolArea)) {
                return poolArea;
            }
        } while (true);
    }

    public static String enterFloor() {
        String floor;
        do {
            System.out.println("Nhập số tầng (Số tầng phải là số nguyên dương.)");
            floor = scanner.nextLine();
            if (FacilityCheck.checkFloor(floor)) {
                return floor;
            }
        } while (true);
    }

    public static String enterFreeService() {
        String freeService;
        do {
            System.out.println("Nhập dịch vụ miễn phí đi kèm (dịch vụ miễn phí đi kèm  phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường)");
            freeService = scanner.nextLine();
            if (FacilityCheck.checkFreeService(freeService)) {
                return freeService;
            }
        } while (true);
    }

    public static void main(String[] args) {
//      do {
//          try {
//              System.out.println("nhap");
//              int are = Integer.parseInt(scanner.nextLine());
//              if (are > 30) {
//                  break;
//              }
//          }catch (NumberFormatException e){
//              System.err.println("adasd");
//          }
//      }while (true);

    }
}
