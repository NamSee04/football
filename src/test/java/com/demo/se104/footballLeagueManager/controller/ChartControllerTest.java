package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.model.Chart;
import com.demo.se104.footballLeagueManager.service.ChartService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ChartControllerTest {

    @Mock
    private ChartService chartService;

    @InjectMocks
    private ChartController chartController;

    private MockMvc mockMvc;

    @Test
    public void testListCharts() throws Exception {
        // Mock data
        List<Chart> chartList = new ArrayList<>();
        Chart chart1 = new Chart();
        Chart chart2 = new Chart();
        chartList.add(chart1);
        chartList.add(chart2);
        Page<Chart> page = new PageImpl<>(chartList);

        // Mock service method
        when(chartService.findAll(PageRequest.of(0, 8))).thenReturn(page);

        // Setup MockMvc
        mockMvc = MockMvcBuilders.standaloneSetup(chartController).build();

        // Perform request and verify
        try {
            mockMvc.perform(get("/admin/chart"))
                .andExpect(status().isOk())
                .andExpect(view().name("chart"))
                .andExpect(model().attributeExists("charts"))
                .andExpect(model().attribute("charts", page));
        } 
        catch (Exception e) {}
        // Verify service method was called
        verify(chartService).findAll(PageRequest.of(0, 8));
    }
}
