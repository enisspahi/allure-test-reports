package com.enisspahi.example.service;

import io.qameta.allure.*;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    private Calculator calculator = new Calculator();

    @ParameterizedTest
    @CsvSource({
            "1.0, 1.0, 2.0, 0.0, 1.0, 1.0",
            "2.0, 1.0, 3.0, 1.0, 2.0, 3.0"
    })
    @DisplayName("Calculates Correctly")
    @Feature("Calculator")
    @Story("Calculator: All operations")
    @Issue("Story-2")
    void calculatesCorrectly(double a, double b, double expectedPlus, double expectedMinus, double expectedMultiply, double expectedDivide) {
        verifyPlus(a, b, expectedPlus);
        verifyMinus(a, b, expectedMinus);
        verifyMultiplication(a, b, expectedMultiply);
        verifyDivision(a, b, expectedDivide);
    }

    @Step("Verify plus")
    void verifyPlus(double a, double b, double expected) {
        var result = calculator.plus(a, b);
        assertThat(result).isEqualTo(expected);
        Allure.attachment("result", String.format("The result of %s + %s = %s", a, b, result));
    }

    @Step("Verify minus")
    void verifyMinus(double a, double b, double expected) {
        var result = calculator.minus(a, b);
        assertThat(result).isEqualTo(expected);
        Allure.attachment("result", String.format("The result of %s - %s = %s", a, b, result));
    }

    @Step("Verify multiplication")
    void verifyMultiplication(double a, double b, double expected) {
        var result = calculator.multiply(a, b);
        assertThat(result).isEqualTo(expected);
        Allure.attachment("result", String.format("The result of %s * %s = %s", a, b, result));

    }

    @Step("Verify division")
    void verifyDivision(double a, double b, double expected) {
        // Allure Report doesn't view Native Junit5 assertions
        var result = calculator.divide(a, b);
        assertEquals(expected, result);
        Allure.attachment("result", String.format("The result of %s / %s = %s", a, b, result));
    }

}
