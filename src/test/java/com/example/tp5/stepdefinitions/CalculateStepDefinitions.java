package com.example.tp5.stepdefinitions;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;




public class CalculateStepDefinitions {
    private final WebDriver driver = new FirefoxDriver();
    WebDriverWait wait; // Ici, 10 est le délai d'attente en secondes

    @Given("I am on the quadratic equation calculator page")
    public void i_am_on_the_quadratic_equation_calculator_page() {
        // Replace with the actual URL of your calculator page
        driver.get("http://localhost:8081/");
    }

    @When("I enter {string} in the {string} input field")
    public void i_enter_in_the_input_field(String value, String field) {
        // Assuming the field is the ID of the input field
        WebElement inputField = driver.findElement(By.id(field));
        inputField.clear(); // Clear any pre-filled value in the input field
        inputField.sendKeys(value); // Enter the value into the input field
    }

    @When("I click on the button")
    public void I_click_on_the_button() {
        // Write code here that turns the phrase above into concrete actions
        driver.findElement(By.id("calculer")).click();

    }

    @Then("I should see the solution of the equation in the {string} section")
    public void I_should_see_the_solution_of_the_equation_in_the_section(String section) {
        WebElement resultSection = driver.findElement(By.id(section));
        String resultText = resultSection.getText();
        // Here, you can add more specific validation based on expected result format
        assertTrue(resultText.contains("solution"));
    }

    @Then("I should see an error message indicating that 'a' cannot be zero")
    public void i_should_see_an_error_message_indicating_that_a_cannot_be_zero() {
        WebElement errorMessage = driver.findElement(By.id("resultat")); // Replace with actual ID or selector
        assertEquals("Error message is not as expected", "Coefficient 'a' must be non-zero for a quadratic equation.", errorMessage.getText());
    }

    @When("I do not enter any value in the {string}, {string}, and {string} input fields")
    public void i_do_not_enter_any_value_in_the_input_fields(String field1, String field2, String field3) {
        clearInputField(field1);
        clearInputField(field2);
        clearInputField(field3);
    }

    private void clearInputField(String fieldId) {
        WebElement field = driver.findElement(By.id(fieldId));
        field.clear();
    }

    @Then("I should see an error message indicating that all fields are required")
    public void i_should_see_an_error_message_indicating_that_all_fields_are_required() {
        WebElement errorMessage = driver.findElement(By.id("resultat")); // Replace with actual ID or selector
        assertEquals("Error message is not as expected", "Veuillez entrer les valeurs de a, b et c.", errorMessage.getText());
    }

}
