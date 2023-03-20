package com.example.equationcalculation.controller;

import com.example.equationcalculation.dto.CalcArgsDTO;
import com.example.equationcalculation.service.SquareEquationCalculatorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class SquareEquationCalculatorController {
    private final SquareEquationCalculatorService calcService;

    @GetMapping
    public ResponseEntity<String> calculateEquation(@RequestBody CalcArgsDTO calcArgs) {
        return ResponseEntity.ok(calcService.calculateEquationWithStringRepresentation(calcArgs));
    }
}


