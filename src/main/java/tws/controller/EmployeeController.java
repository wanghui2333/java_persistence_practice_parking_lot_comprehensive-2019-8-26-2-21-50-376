package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.EmployeeMapper;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeMapper.selectAll());
    }


    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        System.out.println("test:"+employee.toString());
        employeeMapper.insert(employee);
        return ResponseEntity.created(URI.create("/employees/" + employee.getEmployeeID())).body(employee);
    }

    @GetMapping("/{id}/parkinglots")
    public ResponseEntity<List<ParkingLot>> getParkingLotList(@PathVariable int id){
        Employee employee = employeeMapper.selectById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        List<ParkingLot> parkingLots = parkingLotMapper.selectByParkingBoyId(id);
        return ResponseEntity.ok(parkingLots);
    }
}
