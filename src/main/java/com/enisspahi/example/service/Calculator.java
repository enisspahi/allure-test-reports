package com.enisspahi.example.service;

import org.springframework.stereotype.Service;

@Service
public class Calculator {

    public double plus(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double divide(double a, double b) {
        return a / b;
    }

}
