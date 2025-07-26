package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void shouldReturnDefaultMessage() throws Exception {
        mockMvc.perform(get("/hello"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }

    @Test
    void shouldReturnCustomMessage() throws Exception {
        mockMvc.perform(get("/hello?name=Matt"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Matt!"));
    }

    @Test
    void shouldReturn200ForInvalidName() throws Exception {
        mockMvc.perform(get("/hello?name="))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello World!"));
    }
}