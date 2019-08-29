package tws.entity;

import java.io.Serializable;
import java.util.List;

public class Employee implements Serializable {

    private int employeeID;
    private String name;
    private int age;
    private List<ParkingLot> parkingLots;

    public Employee() {

    }

    public Employee(int employeeID, String name, int age, List<ParkingLot> parkingLots) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.parkingLots = parkingLots;
    }

    public int getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(int employeeID) {
        this.employeeID = employeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<ParkingLot> getParkingLots() {
        return parkingLots;
    }

    public void setParkingLots(List<ParkingLot> parkingLots) {
        this.parkingLots = parkingLots;
    }
}
