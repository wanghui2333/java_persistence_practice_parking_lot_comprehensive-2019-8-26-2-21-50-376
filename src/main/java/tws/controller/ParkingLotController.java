package tws.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tws.entity.ParkingLot;
import tws.service.ParkingLotService;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/parkingLots")
public class ParkingLotController {
    @Autowired
    private ParkingLotService parkingLotService;

    @GetMapping
    public ResponseEntity<List<ParkingLot>> getAll() {

        return ResponseEntity.ok(parkingLotService.selectAll());
    }

    @GetMapping("/{parkingBoyId}")
    public ResponseEntity<List<ParkingLot>> getParkingLotByParkingBoyId(@PathVariable int parkingBoyId){
        return  ResponseEntity.ok(parkingLotService.selectByParkingBoyId(parkingBoyId));
    }

    @PostMapping
    public ResponseEntity<ParkingLot> insert(@RequestBody ParkingLot parkingLot) {
        parkingLotService.insert(parkingLot);
        return ResponseEntity.created(URI.create("/parkingLots/" + parkingLot.getParkingLotID())).body(parkingLot);
    }

}
