package tws.entity;

/**
 * 功能描述 : TODO
 *
 * @Author : 王辉
 * @Email : wanghui16@zybank.com.cn
 * @Date : 2019-08-29 23:43
 */
public class ParkingLot {
    private int parkingLotID;
    private int availablePositionCount;
    private int capacity;
    private int parkingBoyID;

    public ParkingLot() {

    }

    public ParkingLot(int parkingLotID, int availablePositionCount, int capacity, int parkingBoyID) {
        this.parkingLotID = parkingLotID;
        this.availablePositionCount = availablePositionCount;
        this.capacity = capacity;
        this.parkingBoyID = parkingBoyID;
    }

    public int getParkingLotID() {
        return parkingLotID;
    }

    public void setParkingLotID(int parkingLotID) {
        this.parkingLotID = parkingLotID;
    }

    public int getAvailablePositionCount() {
        return availablePositionCount;
    }

    public void setAvailablePositionCount(int availablePositionCount) {
        this.availablePositionCount = availablePositionCount;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getParkingBoyID() {
        return parkingBoyID;
    }

    public void setParkingBoyID(int parkingBoyID) {
        this.parkingBoyID = parkingBoyID;
    }
}
