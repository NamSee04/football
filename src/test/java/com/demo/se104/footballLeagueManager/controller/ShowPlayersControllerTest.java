package com.demo.se104.footballLeagueManager.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
public class ShowPlayersControllerTest {

    private MockMvc mockMvc;

    private ShowPlayersController showPlayersController;

    @BeforeEach
    public void setUp() {
        showPlayersController = new ShowPlayersController();
        mockMvc = MockMvcBuilders.standaloneSetup(showPlayersController).build();
    }

    @Test
    public void testShowPlayers() throws Exception {
        mockMvc.perform(get("/players"))
                .andExpect(status().isOk())
                .andExpect(view().name("Players"));
    }
}
