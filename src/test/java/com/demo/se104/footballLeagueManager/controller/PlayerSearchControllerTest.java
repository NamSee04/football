package com.demo.se104.footballLeagueManager.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyString;
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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.se104.footballLeagueManager.controller.PlayerSearchController;
import com.demo.se104.footballLeagueManager.model.PlayerSearch;
import com.demo.se104.footballLeagueManager.service.PlayerSearchService;

import java.util.Collections;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class PlayerSearchControllerTest {

    @Mock
    private PlayerSearchService playerSearchService;

    @InjectMocks
    private PlayerSearchController playerSearchController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(playerSearchController).build();
    }

    @Test
    public void testListPlayer() throws Exception {
        Page<PlayerSearch> page = new PageImpl<>(Collections.emptyList());
        when(playerSearchService.findAll(PageRequest.of(0, 5))).thenReturn(page);

        mockMvc.perform(get("/admin/search-players"))
            .andExpect(status().isOk())
            .andExpect(view().name("search-player"))
            .andExpect(model().attributeExists("players"))
            .andExpect(model().attributeExists("player"))
            .andExpect(model().attributeExists("thePage"));
    }

    @Test
    public void testFindPlayer() throws Exception {
        Page<PlayerSearch> page = new PageImpl<>(Collections.emptyList());
        when(playerSearchService.findByName(anyString(), any(PageRequest.class))).thenReturn(page);

        mockMvc.perform(get("/admin/search-players/find")
            .param("query", "Player Name"))
            .andExpect(status().isOk())
            .andExpect(view().name("search-player"))
            .andExpect(model().attributeExists("players"))
            .andExpect(model().attributeExists("player"))
            .andExpect(model().attributeExists("query"))
            .andExpect(model().attributeExists("thePage"));
    }
}
