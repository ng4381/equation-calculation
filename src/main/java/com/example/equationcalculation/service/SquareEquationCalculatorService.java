package com.example.equationcalculation.service;

import com.example.equationcalculation.dto.CalcArgsDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SquareEquationCalculatorService {
    public List<Double> calculateEquation(CalcArgsDTO calcArgs) {
        int a = calcArgs.getA();
        int b = calcArgs.getB();
        int c = calcArgs.getC();
        int d = b * b - 4 * a * c;
        double x1 = 0;
        double x2 = 0;
        if (d < 0) {
            return List.of();
        } else if (d == 0) {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            return List.of(x1);
        } else {
            x1 = (-b + Math.sqrt(d)) / (2 * a);
            x2 = (-b - Math.sqrt(d)) / (2 * a);
            return List.of(x1, x2);
        }
    }

    public String calculateEquationWithStringRepresentation(CalcArgsDTO calcArgs) {
        List<Double> list = calculateEquation(calcArgs);
        if (list.isEmpty()) {
            return "Корней нет";
        } else if (list.size() == 1) {
            return String.format("Один корень. X = %s", list.get(0));
        } else if (list.size() == 2) {
            return String.format("Два корня. X1 = %s X2 = %s", list.get(0), list.get(1));
        }
        return "Ошибка сервера при расчете!";
    }
}
