package com.enisspahi.example.service;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorRuntimeAPITests {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1.0, 1.0, 2.0, 0.0, 1.0, 1.0",
            "2.0, 1.0, 3.0, 1.0, 2.0, 2.0"
    })
    @DisplayName("Calculates Correctly")
    void calculatesCorrectly(double a, double b, double expectedPlus, double expectedMinus, double expectedMultiply, double expectedDivide) {
        Allure.feature("Calculator with Runtime API");
        Allure.story("Calculator: All operations");
        Allure.issue("Story 3", "");

        Allure.step("Verify plus", step -> {
            var result = calculator.plus(a, b);
            assertThat(result).isEqualTo(expectedPlus);
            Allure.attachment("result", String.format("The result of %s + %s = %s", a, b, result));
        });

        Allure.step("Verify minus", step -> {
            var result = calculator.minus(a, b);
            assertThat(result).isEqualTo(expectedMinus);
            Allure.attachment("result", String.format("The result of %s - %s = %s", a, b, result));
        });

        Allure.step("Verify multiplication", step -> {
            var result = calculator.multiply(a, b);
            assertThat(result).isEqualTo(expectedMultiply);
            Allure.attachment("result", String.format("The result of %s * %s = %s", a, b, result));
        });

        Allure.step("Verify division", step -> {
            var result = calculator.divide(a, b);
            assertThat(result).isEqualTo(expectedDivide);
            Allure.attachment("result", String.format("The result of %s / %s = %s", a, b, result));
        });
    }

}
