package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;
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
@Component
public interface ParkingLotMapper {

    @Select("select * from parkingLot")
    List<ParkingLot> selectAll();

    @Insert("insert into parkingLot values(#{parkingLot.parkingLotID},#{parkingLot.availablePositionCount}" +
            ",#{parkingLot.capacity},#{parkingLot.parkingBoyID})")
    void insert(@Param("parkingLot") ParkingLot parkingLot);

    @Select("select * from parkingLot where parkingBoyID = #{parkingBoyId}")
    List<ParkingLot> selectByParkingBoyId(@Param("parkingBoyId")int parkingBoyId);
}
