package com.example.equationcalculation.service;

import com.example.equationcalculation.dto.CalcArgsDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class SquareEquationCalculatorServiceTest {

    private SquareEquationCalculatorService squareEquationCalculatorService = new SquareEquationCalculatorService();

    @Test
    public void shouldReturnNoResult() {
        List<Double> res = squareEquationCalculatorService.calculateEquation(new CalcArgsDTO(1, 1, 1));
        Assertions.assertIterableEquals(res, List.of());
    }

    @Test
    public void shouldReturnOneRoot() {
        List<Double> res = squareEquationCalculatorService.calculateEquation(new CalcArgsDTO(1, 12, 36));
        Assertions.assertIterableEquals(res, List.of(-6.0));
    }

    @Test
    public void shouldReturnTwoRoots() {
        List<Double> res = squareEquationCalculatorService.calculateEquation(new CalcArgsDTO(1, -2, -3));
        Assertions.assertIterableEquals(res, List.of(3.0, -1.0));
    }

}