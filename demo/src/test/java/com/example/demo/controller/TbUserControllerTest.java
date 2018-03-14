package com.example.demo.controller;

import com.example.demo.DemoApplicationTests;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author donggua
 * @version 1.0
 * @create 2018/3/13
 */
@AutoConfigureMockMvc
public class TbUserControllerTest extends DemoApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void queryOne() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/user/7"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }

}