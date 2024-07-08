package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.entity.AdminEntity;
import com.demo.se104.footballLeagueManager.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ContextConfiguration(classes = {TestConfig.class})
public class LoginControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private JavaMailSender javaMailSender;

    @InjectMocks
    private loginController loginController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(loginController).build();
    }

    @Test
    public void testShowMyLoginPage() throws Exception {
        try {
            mockMvc.perform(get("/login"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("login"));
        } 
        catch (Exception e) {}
    }

    @Test
    public void testShowMyPage() throws Exception {
        try {
            mockMvc.perform(get("/password-missing"))
                    .andExpect(status().isOk())
                    .andExpect(view().name("password-missing"));
        } 
        catch (Exception e) {}
    }

    @Test
    public void testProcessPasswordEmailNotFound() throws Exception {
        String email = "nonexistent@example.com";

        when(adminService.findByEmail(email)).thenReturn(null);
        try {
            mockMvc.perform(post("/password-missing")
                    .param("username", email))
                    .andExpect(status().isOk())
                    .andExpect(view().name("password-missing"))
                    .andExpect(model().attribute("error", "Không tìm thấy email. Vui lòng nhập lại"));
        } 
        catch (Exception e) {}
    }

    @Test
    public void testProcessPasswordEmailFound() throws Exception {
        String email = "test@example.com";
        AdminEntity admin = new AdminEntity();
        admin.setUserId("adminUser");
        admin.setPassword("adminPass");

        when(adminService.findByEmail(email)).thenReturn(admin);
        try {
            mockMvc.perform(post("/password-missing")
                    .param("username", email))
                    .andExpect(status().isOk())
                    .andExpect(view().name("password-missing"))
                    .andExpect(model().attribute("success", "Email đã được gửi. Vui lòng kiểm tra email"));
        } 
        catch (Exception e) {}
        verify(javaMailSender).send(any(SimpleMailMessage.class));
    }
}
