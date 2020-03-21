package com.example.demo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class DemoControllerTest {

    private MockMvc mockMvc;

    private DemoController demoController;

    @Mock
    private DemoMapper demoMapper;

    @BeforeEach
    void setup() {

        MockitoAnnotations.initMocks(this);
        demoController = new DemoController(demoMapper);
        this.mockMvc = MockMvcBuilders.standaloneSetup(demoController).build();
    }

    @Test
    void index() throws Exception {
        mockMvc.perform(
                get("/tasks"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void create() throws Exception {
        mockMvc.perform(
                post("/tasks")
                        .param("id", "1")
                        .param("title", "hoge"))
                .andExpect(redirectedUrl("/tasks"));
    }

    @Test
    void add() throws Exception {
        mockMvc.perform(
                get("/tasks/new"))
                .andExpect(status().isOk())
                .andExpect(view().name("add"));
    }

    @Test
    void edit() throws Exception {
        mockMvc.perform(
                get("/tasks/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("edit"));
    }

    @Test
    void update() throws Exception {
        mockMvc.perform(
                post("/tasks/update")
                        .param("id", "1")
                        .param("title", "hoge"))
                .andExpect(redirectedUrl("/tasks"));
    }

    @Test
    void delete() throws Exception {
        mockMvc.perform(
                get("/tasks/delete/1"))
                .andExpect(redirectedUrl("/tasks"));
    }
}
