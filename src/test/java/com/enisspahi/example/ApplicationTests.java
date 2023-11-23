package com.enisspahi.example;

import io.qameta.allure.*;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import static io.qameta.allure.SeverityLevel.CRITICAL;
import static org.hamcrest.CoreMatchers.is;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	@LocalServerPort
	private int port;

	@BeforeAll
	public static void setup() {
		RestAssured.filters(new AllureRestAssured());
	}

	@BeforeEach
	public void setupPort() {
		RestAssured.port = port;
	}

	@ParameterizedTest
	@CsvSource({
			"1.0, 1.0, 2.0",
			"2.0, 1.0, 3.0"
	})
	@DisplayName("Calculates Plus Correctly")
	@Feature("Calculator API")
	@Story("Calculator API: Plus endpoint")
	@Issue("Story-1")
	void calculatesPlusCorrectly(double a, double b, float expectedPlus) {
		RestAssured
				.given()
					.body(buildRequest(a, b))
					.contentType(ContentType.JSON)
				.when()
					.post("/calculator/plus")
				.then()
					.assertThat()
					.statusCode(200)
					.body("result", is(expectedPlus));
	}


	@ParameterizedTest
	@CsvSource({
			"1.0, 1.0, 0.0",
			"2.0, 1.0, 1.0"
	})
	@DisplayName("Calculates Minus Correctly")
	@Feature("Calculator API")
	@Story("Calculator API: Minus endpoint")
	@Issue("Story-1")
	void calculatesMinusCorrectly(double a, double b, float expectedMinus) {
		RestAssured
				.given()
				.body(buildRequest(a, b))
				.contentType(ContentType.JSON)
				.when()
				.post("/calculator/minus")
				.then()
				.assertThat()
				.statusCode(200)
				.body("result", is(expectedMinus));
	}

	@ParameterizedTest
	@CsvSource({
			"1.0, 1.0, 1.0",
			"2.0, 1.0, 2.0"
	})
	@DisplayName("Calculates Multiplication Correctly")
	@Feature("Calculator API")
	@Story("Calculator API: Multiply endpoint")
	@Issue("Story-1")
	void calculatesMultiplicationCorrectly(double a, double b, float expectedMinus) {
		RestAssured
				.given()
				.body(buildRequest(a, b))
				.contentType(ContentType.JSON)
				.when()
				.post("/calculator/multiply")
				.then()
				.assertThat()
				.statusCode(200)
				.body("result", is(expectedMinus));
	}

	@ParameterizedTest
	@CsvSource({
			"1.0, 1.0, 1.0",
			"2.0, 1.0, 2.0"
	})
	@DisplayName("Calculates Division Correctly")
	@Feature("Calculator API")
	@Story("Calculator API: Divide endpoint")
	@Issue("Story-1")
	void calculatesDivisionCorrectly(double a, double b, float expectedMinus) {
		RestAssured
				.given()
				.body(buildRequest(a, b))
				.contentType(ContentType.JSON)
				.when()
				.post("/calculator/divide")
				.then()
				.assertThat()
				.statusCode(200)
				.body("result", is(expectedMinus));
	}

	private static String buildRequest(double a, double b) {
		return String.format(
				"""
				{
					"a": %s,
					"b": %s
				}	
				""", a, b);
	}
}
