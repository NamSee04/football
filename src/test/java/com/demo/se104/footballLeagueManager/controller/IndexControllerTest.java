package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.model.Chart;
import com.demo.se104.footballLeagueManager.model.Match;
import com.demo.se104.footballLeagueManager.model.Report;
import com.demo.se104.footballLeagueManager.service.ChartService;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.ReportService;
import com.demo.se104.footballLeagueManager.utils.NearestFutureMatchUtils;
import com.demo.se104.footballLeagueManager.utils.NearestPastMatchUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class IndexControllerTest {

    @Mock
    private ChartService chartService;

    @Mock
    private MatchService matchService;

    @Mock
    private ReportService reportService;

    @InjectMocks
    private IndexController indexController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();
    }

    @Test
    public void testShowHome() throws Exception {
        // Mock data
        List<Chart> charts = new ArrayList<>();
        List<Match> matches = new ArrayList<>();
        List<Report> reports = new ArrayList<>();
        Match nearestFutureMatch = new Match();
        Match nearestPastMatch = new Match();

        // Mock service methods
    }
}
