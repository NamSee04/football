package com.demo.se104.footballLeagueManager.controller;

import com.demo.se104.footballLeagueManager.model.Admin;
import com.demo.se104.footballLeagueManager.service.AdminService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.Arrays;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

public class AdminControllerTest {

    @Mock
    private AdminService adminService;

    @Mock
    private Model model;

    @InjectMocks
    private AdminController adminController;

    private MockMvc mockMvc;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(adminController).build();
    }

    @Test
    public void testListAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("admin");
        Page<Admin> page = new PageImpl<>(Arrays.asList(admin));
        
        when(adminService.findAll(any(PageRequest.class))).thenReturn(page);

        mockMvc.perform(get("/admin/accounts")
                .param("page", "0"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("admins"))
                .andExpect(view().name("admin"));
    }

    @Test
    public void testSaveAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("admin");
        admin.setEmail("admin@example.com");

        when(adminService.findByEmail(anyString())).thenReturn(null);
        when(adminService.findByUserId(anyString())).thenReturn(null);
        when(adminService.findById(anyInt())).thenReturn(admin);
        
        mockMvc.perform(post("/admin/accounts")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                .param("page", "0")
                .param("id", "1")
                .param("username", "admin")
                .param("email", "admin@example.com")
                .param("password", "password"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/accounts?page=0"));
        
        verify(adminService, times(1)).save(any(Admin.class));
    }

    @Test
    public void testDeleteAdmin() throws Exception {
        Admin admin = new Admin();
        admin.setId(1);
        admin.setUsername("admin");
        when(adminService.findById(1)).thenReturn(admin);

        mockMvc.perform(get("/admin/accounts/delete")
                .param("page", "0")
                .param("adminId", "1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/admin/accounts?page=0"));

        verify(adminService, times(1)).deleteById(1);
    }

    @Test
    public void testDeleteAdminNotFound() throws Exception {
        when(adminService.findById(1)).thenReturn(null);

        mockMvc.perform(get("/admin/accounts/delete")
                .param("page", "0")
                .param("adminId", "1"))
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("error"))
                .andExpect(view().name("admin"));

        verify(adminService, never()).deleteById(anyInt());
    }
}
