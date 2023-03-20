package com.example.equationcalculation.controller;

import com.example.equationcalculation.dto.CalcArgsDTO;
import com.example.equationcalculation.service.SquareEquationCalculatorService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class SquareEquationCalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private SquareEquationCalculatorService squareEquationCalculatorService;

    @Test
    public void shouldReturnResult() throws Exception {
        when(squareEquationCalculatorService.calculateEquationWithStringRepresentation(any()))
                .thenReturn(anyString());

        this.mockMvc.perform(get("/").contentType(MediaType.APPLICATION_JSON)
                        .content(asJsonString(new CalcArgsDTO(1, 1, 1))))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().string(""));
    }

    private String asJsonString(final Object obj) {
        try {
            return new ObjectMapper().writeValueAsString(obj);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}