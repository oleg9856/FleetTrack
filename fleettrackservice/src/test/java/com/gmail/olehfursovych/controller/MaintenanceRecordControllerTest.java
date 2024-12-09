package com.gmail.olehfursovych.controller;

import com.gmail.olehfursovych.dto.MaintenanceRecordDTO;
import com.gmail.olehfursovych.entity.MaintenanceRecord;
import com.gmail.olehfursovych.service.IMaintenanceRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Collections;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class MaintenanceRecordControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private IMaintenanceRecordService maintenanceRecordService;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void testGetAllMaintenanceRecords() throws Exception {
        MaintenanceRecord record = new MaintenanceRecord();
        record.setRecordId(1L);
        when(maintenanceRecordService.getAllMaintenanceRecords()).thenReturn(Collections.singletonList(record));

        mockMvc.perform(get("/api/v1/maintenance-records"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].recordId").value(1L));
    }

    @Test
    public void testCreateMaintenanceRecord() throws Exception {
        MaintenanceRecordDTO recordDTO = new MaintenanceRecordDTO();
        recordDTO.setRecordId(1L);
        MaintenanceRecord record = new MaintenanceRecord();
        record.setRecordId(1L);
        doNothing().when(maintenanceRecordService).saveMaintenanceRecord(any(MaintenanceRecord.class));

        mockMvc.perform(post("/api/v1/maintenance-records")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"recordId\":1}"))
                .andExpect(status().isOk());
    }

    @Test
    public void testUpdateMaintenanceRecord() throws Exception {
        MaintenanceRecordDTO recordDTO = new MaintenanceRecordDTO();
        recordDTO.setRecordId(1L);
        MaintenanceRecord record = new MaintenanceRecord();
        record.setRecordId(1L);
        when(maintenanceRecordService.updateMaintenanceRecord(eq(1L), any(MaintenanceRecord.class))).thenReturn(record);

        mockMvc.perform(put("/api/v1/maintenance-records/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"recordId\":1}"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.recordId").value(1L));
    }

    @Test
    public void testDeleteMaintenanceRecord() throws Exception {
        doNothing().when(maintenanceRecordService).deleteMaintenanceRecord(1L);

        mockMvc.perform(delete("/api/v1/maintenance-records/1"))
                .andExpect(status().isOk());
    }
}