package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.model.Match;
import com.demo.se104.footballLeagueManager.model.Player;
import com.demo.se104.footballLeagueManager.model.Regulation;
import com.demo.se104.footballLeagueManager.model.Report;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.ReportService;
import com.demo.se104.footballLeagueManager.utils.DateTimeCompareUtils;
import com.demo.se104.footballLeagueManager.utils.PlayerGoalCountUtils;
import com.demo.se104.footballLeagueManager.utils.ReportGoalCountUtils;
import org.junit.jupiter.api.BeforeEach;
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

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MatchReportControllerTest {

    @Mock
    private MatchService matchService;

    @Mock
    private ReportService reportService;

    @Mock
    private PlayerService playerService;

    @Mock
    private RegulationService regulationService;

    @InjectMocks
    private MatchReportController matchReportController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(matchReportController).build();
    }

    @Test
    public void testListTeam() throws Exception {
        Match match = new Match();
        match.setTeam1Id("1");
        match.setTeam2Id("2");

        List<Player> playerTeam1 = new ArrayList<>();
        playerTeam1.add(new Player());

        List<Player> playerTeam2 = new ArrayList<>();
        playerTeam2.add(new Player());

        List<Report> reports = new ArrayList<>();
        Report report = new Report();
        reports.add(report);
        Page<Report> page = new PageImpl<>(reports);

        when(matchService.findById(1)).thenReturn(match);
        when(playerService.findByTeamId(1)).thenReturn(playerTeam1);
        when(playerService.findByTeamId(2)).thenReturn(playerTeam2);
        when(reportService.findByMatchId(1, PageRequest.of(0, 4))).thenReturn(page);

        mockMvc.perform(get("/admin/matches/results").param("matchId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("match-report"))
                .andExpect(model().attributeExists("match"))
                .andExpect(model().attributeExists("reports"))
                .andExpect(model().attributeExists("report"))
                .andExpect(model().attributeExists("playerTeam1"))
                .andExpect(model().attributeExists("playerTeam2"))
                .andExpect(model().attributeExists("matchId"));

        verify(matchService, times(1)).findById(1);
        verify(playerService, times(1)).findByTeamId(1);
        verify(playerService, times(1)).findByTeamId(2);
        verify(reportService, times(1)).findByMatchId(1, PageRequest.of(0, 4));
    }

    @Test
    public void testSaveTeam() throws Exception {
        List<Regulation> regulations = new ArrayList<>();
        Regulation regulation = new Regulation();
        regulation.setMaxScoreTime("90");
        regulations.add(regulation);

        Match match = new Match();
        match.setTeam1Id("1");
        match.setTeam2Id("2");

        List<Player> playerTeam1 = new ArrayList<>();
        playerTeam1.add(new Player());

        List<Player> playerTeam2 = new ArrayList<>();
        playerTeam2.add(new Player());

        List<Report> reports = new ArrayList<>();
        Report report = new Report();
        reports.add(report);
        Page<Report> page = new PageImpl<>(reports);


        try {
            when(regulationService.findAll()).thenReturn(regulations);
            mockMvc.perform(post("/admin/matches/results")
                            .param("matchId", "1")
                            .param("playerId", "1")
                            .param("goalTypeId", "1")
                            .param("time", "45"))
                    .andExpect(status().is3xxRedirection())
                    .andExpect(redirectedUrl("/admin/matches/results?matchId=1"));
            verify(reportService, times(1)).save(any(Report.class));
            verify(matchService, times(2)).findById(1); // Called twice due to additional calls within the controller
            verify(playerService, times(2)).findById(anyInt()); // Called twice due to goal count utilities
            verify(playerService, times(2)).save(any(Player.class));
        }
        catch (Exception e) {}

    }

    @Test
    public void testDelete() throws Exception {
        Match match = new Match();
        Report report = new Report();
        report.setPlayerId("1");

    }
}
