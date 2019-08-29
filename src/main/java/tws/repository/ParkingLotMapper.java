package tws.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Service;
import tws.entity.ParkingLot;

import java.util.List;

/**
 * 功能描述 : TODO
 *
 * @Author : 王辉
 * @Email : wanghui16@zybank.com.cn
 * @Date : 2019-08-29 23:42
 */
@Mapper
@Service
public interface ParkingLotMapper {

    List<ParkingLot> selectByParkingBoyId(int id);

    List<ParkingLot> selectAll();
}
