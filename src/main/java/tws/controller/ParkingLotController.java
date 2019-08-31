package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAll() {

        return ResponseEntity.ok(parkingLotMapper.selectAll());
    }

    @GetMapping("/{parkingBoyId}")
    public ResponseEntity<List<ParkingLot>> getParkingLotByParkingBoyId(@PathVariable int parkingBoyId){
        return  ResponseEntity.ok(parkingLotMapper.selectByParkingBoyId(parkingBoyId));
    }

    @PostMapping
    public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
        parkingLotMapper.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parkingLots/" + parkingLot.getParkingLotID())).body(parkingLot);
    }

}
