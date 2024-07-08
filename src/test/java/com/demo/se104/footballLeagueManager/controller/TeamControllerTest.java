package com.demo.se104.footballLeagueManager.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.se104.footballLeagueManager.controller.TeamController;
import com.demo.se104.footballLeagueManager.dao.ChartRepository;
import com.demo.se104.footballLeagueManager.entity.ChartEntity;
import com.demo.se104.footballLeagueManager.entity.TeamEntity;
import com.demo.se104.footballLeagueManager.model.Team;
import com.demo.se104.footballLeagueManager.service.TeamService;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TeamControllerTest {

    @Mock
    private TeamService teamService;

    @Mock
    private ChartRepository chartRepository;

    @InjectMocks
    private TeamController teamController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(teamController).build();
    }

    @Test
    public void testListTeam() throws Exception {
        Page<Team> page = new PageImpl<>(Collections.emptyList());
        when(teamService.findAll(PageRequest.of(0, 5))).thenReturn(page);

        mockMvc.perform(get("/admin/teams"))
            .andExpect(status().isOk())
            .andExpect(view().name("team"))
            .andExpect(model().attributeExists("teams"))
            .andExpect(model().attributeExists("team"));
    }

    @Test
    public void testSaveTeam_NewTeam_Success() throws Exception {
        when(teamService.findByName(anyString())).thenReturn(null);
        when(teamService.save(any(Team.class))).thenReturn(new TeamEntity());

        mockMvc.perform(post("/admin/teams")
            .param("name", "New Team")
            .param("homeGround", "New Ground"))
            .andExpect(redirectedUrl("/admin/teams?page=0"));
    }

    @Test
    public void testSaveTeam_ExistingTeam_Error() throws Exception {
        // Giả lập team đã tồn tại với tên "Existing Team"
        TeamEntity existingTeam = new TeamEntity();
        existingTeam.setId(1);
        existingTeam.setName("Existing Team");
        when(teamService.findByName(anyString())).thenReturn(existingTeam);
        
        // Giả lập team đang được cập nhật với ID là 2
        Team updateTeam = new Team();
        updateTeam.setId(2);
        updateTeam.setName("Existing Team");
        when(teamService.findById(anyInt())).thenReturn(updateTeam);
        
        // Thực hiện yêu cầu POST để cập nhật team với ID là 2 và tên "Existing Team"
        mockMvc.perform(post("/admin/teams")
            .param("id", "2")
            .param("name", "Existing Team")
            .param("homeGround", "Existing Ground"))
            .andExpect(view().name("team"))
            .andExpect(model().attributeExists("error"));
    }

    @Test
    public void testDeleteTeam() throws Exception {
        mockMvc.perform(get("/admin/teams/delete")
            .param("teamId", "1"))
            .andExpect(redirectedUrl("/admin/teams?page=0"));
    }
}
