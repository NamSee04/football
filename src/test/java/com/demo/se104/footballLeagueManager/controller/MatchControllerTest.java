package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.convert.DateTimeConvert;
import com.demo.se104.footballLeagueManager.model.Match;
import com.demo.se104.footballLeagueManager.model.Regulation;
import com.demo.se104.footballLeagueManager.model.Team;
import com.demo.se104.footballLeagueManager.service.MatchService;
import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.TeamService;
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

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(MockitoExtension.class)
public class MatchControllerTest {

    @Mock
    private TeamService teamService;

    @Mock
    private MatchService matchService;

    @Mock
    private PlayerService playerService;

    @Mock
    private RegulationService regulationService;

    @InjectMocks
    private MatchController matchController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(matchController).build();
    }

    @Test
    public void testListTeam() throws Exception {
        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        teams.add(team);

        List<Match> matches = new ArrayList<>();
        Match match = new Match();
        matches.add(match);
        Page<Match> page = new PageImpl<>(matches);

        when(teamService.findAll()).thenReturn(teams);
        when(matchService.findAll(PageRequest.of(0, 5))).thenReturn(page);

        mockMvc.perform(get("/admin/matches"))
                .andExpect(status().isOk())
                .andExpect(view().name("match"))
                .andExpect(model().attributeExists("teams"))
                .andExpect(model().attributeExists("team"))
                .andExpect(model().attributeExists("matches"))
                .andExpect(model().attributeExists("match"))
                .andExpect(model().attributeExists("thePage"))
                .andExpect(model().attribute("thePage", "matches"));

        verify(teamService, times(1)).findAll();
        verify(matchService, times(1)).findAll(PageRequest.of(0, 5));
    }

    @Test
    public void testListMatch() throws Exception {
        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        teams.add(team);

        List<Match> matches = new ArrayList<>();
        Match match = new Match();
        matches.add(match);
        Page<Match> page = new PageImpl<>(matches);

        when(teamService.findAll()).thenReturn(teams);
        when(matchService.findByRoundId(eq(1), eq(PageRequest.of(0, 5)))).thenReturn(page);

        mockMvc.perform(get("/admin/matches/find").param("roundId", "1"))
                .andExpect(status().isOk())
                .andExpect(view().name("match"))
                .andExpect(model().attributeExists("teams"))
                .andExpect(model().attributeExists("team"))
                .andExpect(model().attributeExists("matches"))
                .andExpect(model().attributeExists("match"))
                .andExpect(model().attributeExists("thePage"))
                .andExpect(model().attributeExists("roundId"))
                .andExpect(model().attribute("thePage", "find_matches"))
                .andExpect(model().attribute("roundId", 1));

        verify(teamService, times(1)).findAll();
        verify(matchService, times(1)).findByRoundId(eq(1), eq(PageRequest.of(0, 5)));
    }

    @Test
    public void testSaveMatch() throws Exception {
        List<Regulation> regulations = new ArrayList<>();
        Regulation regulation = new Regulation();
        regulation.setMinNumber(11);
        regulation.setMaxNumber(22);
        regulations.add(regulation);

        List<Team> teams = new ArrayList<>();
        Team team = new Team();
        teams.add(team);

        List<Match> matches = new ArrayList<>();
        Match match = new Match();
        matches.add(match);
        Page<Match> page = new PageImpl<>(matches);

        when(regulationService.findAll()).thenReturn(regulations);
        when(playerService.countByTeamId(anyInt())).thenReturn(15);
        when(matchService.findByDateTime(any())).thenReturn(null);

        mockMvc.perform(post("/admin/matches")
                        .param("team1Id", "1")
                        .param("team2Id", "2")
                        .param("roundId", "1")
                        .param("dateTime", "2024-07-07T12:00:00")
                        .param("homeGround", "Ground"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/matches"));

        verify(matchService, times(1)).save(any(Match.class));
    }

    @Test
    public void testDeleteMatch() throws Exception {
        doNothing().when(matchService).deleteById(1);

        mockMvc.perform(get("/admin/matches/delete").param("matchId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/matches"));

        verify(matchService, times(1)).deleteById(1);
    }
}
