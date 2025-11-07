package com.example.calculator.controller;

import com.example.calculator.model.CalculationRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/calculator")
public class CalculatorController {

    @PostMapping()
    public double calculate(@RequestBody CalculationRequest request) {
        double result;
        switch (request.getOperation().toLowerCase()) {
            case "add":
                result = request.getNum1() + request.getNum2();
                break;
            case "subtract":
                result = request.getNum1() - request.getNum2();
                break;
            case "multiply":
                result = request.getNum1() * request.getNum2();
                break;
            case "divide":
                if (request.getNum2() == 0) {
                    throw new ArithmeticException("Cannot divide by zero");
                }
                result = request.getNum1() / request.getNum2();
                break;
            default:
                throw new IllegalArgumentException("Invalid operation: " + request.getOperation());
        }
        return result;
    }
}
