# Allure Test Reports - Demo

[Allure Test Reporting Tool](https://allurereport.org/) showcase on a Spring Boot Junit 5 project. 

## Project Contents
* Gradle dependency and plugin setup: [build.gradle](build.gradle)
* Allure JUnit 5 (Annotations) example: [CalculatorTests.java](src/test/java/com/enisspahi/example/service/CalculatorTests.java)
* Allure JUnit 5 (Runtime API) example: [CalculatorTuntimeAPITests.java](src/test/java/com/enisspahi/example/service/CalculatorRuntimeAPITests.java)
* Allure Rest Assured example: [ApplicationTests.java](src/test/java/com/enisspahi/example/ApplicationTests.java)
* Allure AssertJ Example
* GitHub Actions pipeline: [pipeline](.github/workflows/gradle.yml)

## How to try
* Run tests
````
./gradlew clean test
````
* Observe native gradle report `build/reports/index.html`
* Generate Allure Report
````
./gradlew allureServe
````
* Compare and see the difference

## References
* [Allure Junit 5 User Guide](https://allurereport.org/docs/junit5/)