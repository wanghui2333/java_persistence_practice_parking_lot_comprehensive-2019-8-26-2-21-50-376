package tws.service;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tws.entity.Employee;
import tws.repository.EmployeeMapper;

import java.util.List;

/**
 * 功能描述 : TODO
 *
 * @Author : 王辉
 * @Email : wanghui16@zybank.com.cn
 * @Date : 2019-08-31 13:44
 */
@Service
public class EmployeeService {

    @Autowired
    EmployeeMapper employeeMapper;

    public List<Employee> selectAll(){

        return employeeMapper.selectAll();
    }

    public void insert(Employee employee){
        employeeMapper.insert(employee);
    }

    public Employee selectById(int id){
        return employeeMapper.selectById(id);
    }

}
