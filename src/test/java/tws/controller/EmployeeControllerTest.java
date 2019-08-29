package tws.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tws.entity.Employee;
import tws.entity.ParkingLot;
import tws.repository.EmployeeMapper;
import tws.repository.ParkingLotMapper;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper ObjectMapper;

    @Autowired
    private EmployeeMapper employeeMapper;
    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @Test
    public void should_return_employees() throws Exception {
        List<Employee> employees = employeeMapper.selectAll();
        String getString = ObjectMapper.writeValueAsString(employees);
        this.mockMvc.perform(get("/employees")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(getString));
    }


    @Test
    public void should_return_create_status() throws Exception {
        Employee employee = new Employee(1,"boy1",18,null);
        String postString = ObjectMapper.writeValueAsString(employee);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/employees")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postString))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().json(postString));
    }

    @Test
    public void should_return_employee_parkingLot() throws Exception {
        List<ParkingLot> parkingLots = parkingLotMapper.selectByParkingBoyId(1);

        String getString = ObjectMapper.writeValueAsString(parkingLots);
        this.mockMvc.perform(get("/employees/" + 1 + "/parkinglots"))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(getString));
    }

}