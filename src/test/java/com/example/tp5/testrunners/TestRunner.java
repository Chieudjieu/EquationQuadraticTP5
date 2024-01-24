package com.example.tp5.testrunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/com/example/tp5/resources/calculate.feature",
        glue = "com.example.tp5.stepdefinitions")
public class TestRunner {
    // This class is left empty as @CucumberOptions defines the test execution
}