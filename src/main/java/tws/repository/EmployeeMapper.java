package tws.repository;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;
import tws.entity.Employee;

import java.util.List;

@Mapper
@Service
public interface EmployeeMapper {
    @Select("select * from employee")
    List<Employee> selectAll();

    @Insert("insert into employee values(#{employee.employeeID},#{employee.name}," +
            "#{employee.age}) ")
    void insert(@Param("employee") Employee employee);

    @Select("select * from employee where parkingBoyID=#{id}")
    Employee selectById(@Param("id") int id);
}
