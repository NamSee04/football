package com.demo.se104.footballLeagueManager.controller;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.demo.se104.footballLeagueManager.controller.RegulationController;
import com.demo.se104.footballLeagueManager.convert.RegulationConvert;
import com.demo.se104.footballLeagueManager.model.Regulation;
import com.demo.se104.footballLeagueManager.service.RegulationService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RegulationControllerTest {

    @Mock
    private RegulationService regulationService;

    @InjectMocks
    private RegulationController regulationController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(regulationController).build();
    }

    @Test
    public void testListRegulation() throws Exception {
        // Mock data
        List<Regulation> regulations = new ArrayList<>();
        Regulation regulation = new Regulation();
        regulation.setId(1);
        regulation.setMinAge(18);
        regulation.setMaxAge(30);
        regulation.setMinNumber(11);
        regulation.setMaxNumber(22);
        regulations.add(regulation);

        when(regulationService.findAll()).thenReturn(regulations);

        mockMvc.perform(get("/admin/regulations"))
                .andExpect(status().isOk())
                .andExpect(view().name("regulation"))
                .andExpect(model().attributeExists("regulation"))
                .andExpect(model().attributeExists("theRegulation"))
                .andExpect(model().attribute("regulation", regulations.get(0)));
    }

    @Test
    public void testSaveAdmin() throws Exception {
        // Mock data
        Regulation regulation = new Regulation();
        regulation.setId(1);
        regulation.setMinAge(18);
        regulation.setMaxAge(30);
        regulation.setMinNumber(11);
        regulation.setMaxNumber(22);
        regulation.setMaxForeignNumber(5);
        regulation.setWinPoint(3);
        regulation.setDrawPoint(1);
        regulation.setLossPoint(0);
        regulation.setMaxScoreTime("90:00:00");
        regulation.setNumberOfGoalType(1);
        regulation.setRankingOrder("ASC");

        when(regulationService.findById(anyInt())).thenReturn(regulation);
        when(regulationService.save(any())).thenReturn(RegulationConvert.convertModelToEntity(regulation));

        mockMvc.perform(post("/admin/regulations")
                .param("id", "1")
                .param("minAge", "18")
                .param("maxAge", "30")
                .param("minNumber", "11")
                .param("maxNumber", "22")
                .param("maxForeignNumber", "5")
                .param("winPoint", "3")
                .param("drawPoint", "1")
                .param("lossPoint", "0")
                .param("maxScoreTime", "90")
                .param("numberOfGoalType", "1")
                .param("rankingOrder", "ASC"))
                .andExpect(redirectedUrl("/admin/regulations"));

        verify(regulationService).save(regulation);
    }
}
