package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;
import tws.service.EmployeeService;
import tws.service.ParkingLotService;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        return ResponseEntity.ok(employeeService.selectAll());
    }


    @PostMapping("")
    public ResponseEntity<Employee> insert(@RequestBody Employee employee) {
        employeeService.insert(employee);
        return ResponseEntity.created(URI.create("/employees/" + employee.getEmployeeID())).body(employee);
    }

    @GetMapping("/{id}/parkinglots")
    public ResponseEntity<List<ParkingLot>> getParkingLotList(@PathVariable int id){
        Employee employee = employeeService.selectById(id);
        if (employee == null) {
            return ResponseEntity.notFound().build();
        }
        List<ParkingLot> parkingLots = parkingLotService.selectByParkingBoyId(id);
        return ResponseEntity.ok(parkingLots);
    }
}
