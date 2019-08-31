package tws.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.util.List;

/**
 * 功能描述 : TODO
 *
 * @Author : 王辉
 * @Email : wanghui16@zybank.com.cn
 * @Date : 2019-08-29 23:42
 */
@Service
public class ParkingLotService {

    @Autowired
    ParkingLotMapper parkingLotMapper;

    public List<ParkingLot> selectAll(){
        return parkingLotMapper.selectAll();
    }

    public void insert(ParkingLot parkingLot){
        parkingLotMapper.insert(parkingLot);
    }

    public List<ParkingLot> selectByParkingBoyId(int parkingBoyId){
        return parkingLotMapper.selectByParkingBoyId(parkingBoyId);
    }
}
