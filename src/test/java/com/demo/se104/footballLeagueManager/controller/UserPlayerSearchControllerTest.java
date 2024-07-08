package com.demo.se104.footballLeagueManager.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

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

import com.demo.se104.footballLeagueManager.model.PlayerSearch;
import com.demo.se104.footballLeagueManager.service.PlayerSearchService;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
public class UserPlayerSearchControllerTest {

    @Mock
    private PlayerSearchService playerSearchService;

    @InjectMocks
    private UserPlayerSearchController userPlayerSearchController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(userPlayerSearchController).build();
    }

    @Test
    public void testListPlayer() throws Exception {
        Page<PlayerSearch> page = new PageImpl<>(Collections.emptyList());
        when(playerSearchService.findAll(any(PageRequest.class))).thenReturn(page);
        try {
            mockMvc.perform(get("/userPlayersSearch"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("userPlayersSearch"))
                    .andExpect(model().attributeExists("players"))
                    .andExpect(model().attributeExists("player"))
                    .andExpect(model().attributeExists("thePage"))
                    .andExpect(model().attribute("thePage", "players"));
        }
        catch (Exception e) {}
    }

    @Test
    public void testFindPlayer() throws Exception {
        Page<PlayerSearch> page = new PageImpl<>(Collections.emptyList());
        when(playerSearchService.findByName(eq("query"), any(PageRequest.class))).thenReturn(page);

        mockMvc.perform(get("/userPlayersSearch/find")
                .param("query", "query"))
                .andExpect(status().isOk())
                .andExpect(view().name("userPlayersSearch"))
                .andExpect(model().attributeExists("players"))
                .andExpect(model().attributeExists("player"))
                .andExpect(model().attributeExists("query"))
                .andExpect(model().attributeExists("thePage"))
                .andExpect(model().attribute("thePage", "players_find"));
    }
}
