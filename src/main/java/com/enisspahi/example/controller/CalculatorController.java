package com.enisspahi.example.controller;

import com.enisspahi.example.service.Calculator;
import org.springframework.web.bind.annotation.*;

@RestController()
@RequestMapping("calculator")
public class CalculatorController {

    private final Calculator calculator;


    public CalculatorController(Calculator calculator) {
        this.calculator = calculator;
    }

    @PostMapping("/plus")
    Response plus(@RequestBody Request request) {
        var result = calculator.plus(request.a(), request.b());
        return new Response(result);
    }

    @PostMapping("/minus")
    Response minus(@RequestBody Request request) {
        var result = calculator.minus(request.a(), request.b());
        return new Response(result);
    }

    @PostMapping("/multiply")
    Response multiply(@RequestBody Request request) {
        var result = calculator.multiply(request.a(), request.b());
        return new Response(result);
    }

    @PostMapping("/divide")
    Response divide(@RequestBody Request request) {
        var result = calculator.divide(request.a(), request.b());
        return new Response(result);
    }

}
