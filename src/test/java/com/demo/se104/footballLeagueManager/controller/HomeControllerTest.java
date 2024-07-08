package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.model.Match;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.TeamService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class HomeControllerTest {

    @Mock
    private TeamService teamService;

    @Mock
    private MatchService matchService;

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }

    @Test
    public void testShowHome() throws Exception {
        // Mock data
        Integer teamCount = 5;
        List<Match> matches = new ArrayList<>();
        Match match1 = new Match();
        Match match2 = new Match();
        matches.add(match1);
        matches.add(match2);

        // Mock service methods
        when(teamService.countAll()).thenReturn(teamCount);
        when(matchService.findByDateTime()).thenReturn(matches);

        // Perform request and verify
        try {
            mockMvc.perform(get("/admin/home"))
                .andExpect(status().isOk())
                .andExpect(view().name("home"))
                .andExpect(model().attributeExists("teamCount"))
                .andExpect(model().attributeExists("matches"))
                .andExpect(model().attribute("teamCount", teamCount))
                .andExpect(model().attribute("matches", matches));
        }
        catch (Exception e) {}
        // Verify service methods were called
        verify(teamService, times(1)).countAll();
        verify(matchService, times(1)).findByDateTime();
    }
}
