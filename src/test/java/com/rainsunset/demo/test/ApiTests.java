/**
 * Company
 * Copyright (C) 2004-2018 All Rights Reserved.
 */
package com.rainsunset.demo.test;

import com.rainsunset.demo.DemoApplication;
import com.rainsunset.demo.controller.apiController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author ligw
 * @version $Id ApiTest.java, v 0.1 2018-07-09 17:24 ligw Exp $$
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class ApiTests {

    private MockMvc mockmvc;

    @Before
    public void setup()throws Exception{
        mockmvc = MockMvcBuilders.standaloneSetup(new apiController()).build();
    }

    @Test
    public void hello() throws Exception{
        mockmvc.perform(MockMvcRequestBuilders.get("/test/hello").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().string(equalTo("hellow Spring Cloud")));
    }


}
