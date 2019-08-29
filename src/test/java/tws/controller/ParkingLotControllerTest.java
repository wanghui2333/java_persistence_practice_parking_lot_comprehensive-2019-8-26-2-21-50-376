package tws.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import tws.entity.ParkingLot;
import tws.repository.ParkingLotMapper;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ParkingLotControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private com.fasterxml.jackson.databind.ObjectMapper ObjectMapper;

    @Autowired
    private ParkingLotMapper parkingLotMapper;

    @Test
    public void should_Return_prkingLots() throws Exception {
        List<ParkingLot> parkingLots = parkingLotMapper.selectAll();
        String getString = ObjectMapper.writeValueAsString(parkingLots);
        this.mockMvc.perform(get("/parkingLots")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().json(getString));
    }


    @Test
    public void should_return_create_status() throws Exception {
        ParkingLot parkingLots = new ParkingLot();
        String postString = ObjectMapper.writeValueAsString(parkingLots);
        this.mockMvc
                .perform(MockMvcRequestBuilders.post("/parkingLots")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(postString))
                .andDo(print()).andExpect(status().isCreated())
                .andExpect(content().json(postString));
    }
}