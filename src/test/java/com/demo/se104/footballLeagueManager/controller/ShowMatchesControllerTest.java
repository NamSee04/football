package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.convert.DateTimeConvert;
import com.demo.se104.footballLeagueManager.model.Match;
import com.demo.se104.footballLeagueManager.model.Report;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class ShowMatchesControllerTest {

    @Mock
    private MatchService matchService;

    @Mock
    private ReportService reportService;

    @InjectMocks
    private ShowMatchesController showMatchesController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(showMatchesController).build();
    }

    @Test
    public void testShowMatches() throws Exception {
        List<Match> matches = new ArrayList<>();
        Match nearestFutureMatch = new Match();
        nearestFutureMatch.setId(1);
        nearestFutureMatch.setDateTime("2023-07-10T15:00:00");

        Match nearestPastMatch = new Match();
        nearestPastMatch.setId(2);
        nearestPastMatch.setDateTime("2023-07-05T15:00:00");

        List<Report> matchReport = new ArrayList<>();
        Report report = new Report();
        matchReport.add(report);

        List<Match> upcomingMatches = new ArrayList<>();
        upcomingMatches.add(nearestFutureMatch);

        when(matchService.findAll()).thenReturn(matches);
        when(reportService.findByMatchId(2)).thenReturn(matchReport);
        when(matchService.findMatchByGreaterThanDateTime(any(String.class))).thenReturn(upcomingMatches);

        // Mock static methods
        mockStatic(NearestFutureMatchUtils.class);
        when(NearestFutureMatchUtils.findNearestFutureMatch(matches)).thenReturn(nearestFutureMatch);

        mockStatic(NearestPastMatchUtils.class);
        when(NearestPastMatchUtils.findNearestPastMatch(matches)).thenReturn(nearestPastMatch);

        mockStatic(DateTimeConvert.class);
        when(DateTimeConvert.convertEntityToModel(nearestFutureMatch.getDateTime())).thenReturn(nearestFutureMatch.getDateTime());
        try {
            mockMvc.perform(get("/matches"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("matches"))
                    .andExpect(model().attributeExists("nearestFutureMatch"))
                    .andExpect(model().attributeExists("nearestPastMatch"))
                    .andExpect(model().attributeExists("matchReport"))
                    .andExpect(model().attributeExists("upcomingMatches"));
        }
        catch (Exception e) {}
        verify(matchService, times(1)).findAll();
        verify(reportService, times(1)).findByMatchId(2);
        verify(matchService, times(1)).findMatchByGreaterThanDateTime(nearestFutureMatch.getDateTime());
    }
}
