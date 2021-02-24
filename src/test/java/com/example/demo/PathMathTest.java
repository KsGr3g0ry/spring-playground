package com.example.demo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static java.lang.String.format;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.awt.*;

@WebMvcTest(PathMath.class)
public class PathMathTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testPathMath() throws Exception{
        int length = 42;
        int width = 56;
        int height = 79;
        this.mvc.perform(get(format("/math/volume/%d/%d/%d", length, width, height)))
                .andExpect(status().isOk())
                .andExpect(content().string("The volume of a 42x56x79 rectangle is 185808"));
    }
}

/*
/math/volume/42/56/79
This endpoint should take 3 Path Variables:

length
width
height

 */