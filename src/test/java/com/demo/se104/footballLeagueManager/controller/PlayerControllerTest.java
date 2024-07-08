package com.demo.se104.footballLeagueManager.controller;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.se104.footballLeagueManager.controller.PlayerController;
import com.demo.se104.footballLeagueManager.model.Player;
import com.demo.se104.footballLeagueManager.model.Regulation;
import com.demo.se104.footballLeagueManager.model.Team;
import com.demo.se104.footballLeagueManager.service.PlayerService;
import com.demo.se104.footballLeagueManager.service.RegulationService;
import com.demo.se104.footballLeagueManager.service.TeamService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class PlayerControllerTest {

    @Mock
    private PlayerService playerService;

    @Mock
    private TeamService teamService;

    @Mock
    private RegulationService regulationService;

    @InjectMocks
    private PlayerController playerController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerController).build();
    }

    @Test
    public void testListPlayer() throws Exception {
        int teamId = 1;
        Page<Player> page = new PageImpl<>(Collections.emptyList());
        Team team = new Team();
        when(playerService.findByTeamId(teamId, PageRequest.of(0, 5))).thenReturn(page);
        when(teamService.findById(teamId)).thenReturn(team);

        mockMvc.perform(get("/admin/players")
                .param("teamId", String.valueOf(teamId)))
            .andExpect(status().isOk())
            .andExpect(view().name("player"))
            .andExpect(model().attributeExists("players"))
            .andExpect(model().attributeExists("player"))
            .andExpect(model().attributeExists("team"))
            .andExpect(model().attributeExists("teamId"));
    }

    @Test
    public void testSavePlayer_NewPlayer_Success() throws Exception {
        int teamId = 1;
        int page = 0;

        // Mock regulationService.findAll() to return a list containing one Regulation
        Regulation regulation = new Regulation();
        regulation.setMaxNumber(10); // Set maxNumber to a valid value
        regulation.setMaxForeignNumber(5); // Set maxForeignNumber to a valid value
        regulation.setMinAge(18); // Set minAge to a valid value
        regulation.setMaxAge(35); // Set maxAge to a valid value
        List<Regulation> regulations = Collections.singletonList(regulation);
        when(regulationService.findAll()).thenReturn(regulations);

        when(playerService.countByTeamId(anyInt())).thenReturn(0);
        when(playerService.countByPlayerTypeIdAndTeamId(anyInt(), anyInt())).thenReturn(0);

        mockMvc.perform(post("/admin/players")
                    .param("teamId", String.valueOf(teamId))
                    .param("page", String.valueOf(page))
                    .param("name", "A")
                    .param("birthday", "08/11/2004")
                    .param("playerTypeId", "1") // Ensure playerTypeId is set correctly
                    .param("playerType", "1") // Ensure playerType is set correctly
                    .param("position", "Hậu vệ"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/players?page=" + page + "&teamId=" + teamId));

        verify(playerService, times(1)).save(any(Player.class));
    }





    @Test
    public void testDeletePlayer() throws Exception {
        int playerId = 1;
        int teamId = 1;

        mockMvc.perform(get("/admin/players/delete")
                .param("playerId", String.valueOf(playerId))
                .param("teamId", String.valueOf(teamId)))
            .andExpect(status().is3xxRedirection())
            .andExpect(redirectedUrl("/admin/players?teamId=" + teamId));

        verify(playerService, times(1)).deleteById(playerId);
    }
}
