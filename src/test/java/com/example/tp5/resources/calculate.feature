Feature: Quadratic Equation Calculator

  Scenario: Successful calculation of quadratic equation
    Given I am on the quadratic equation calculator page
    When I enter "2" in the "a" input field
    And I enter "5" in the "b" input field
    And I enter "-3" in the "c" input field
    And I click on the button
    Then I should see the solution of the equation in the "resultat" section

  Scenario: Calculation with a zero 'a' coefficient
    Given I am on the quadratic equation calculator page
    When I enter "0" in the "a" input field
    And I enter "4" in the "b" input field
    And I enter "2" in the "c" input field
    And I click on the button
    Then I should see an error message indicating that 'a' cannot be zero

  Scenario: Calculation with empty coefficients
    Given I am on the quadratic equation calculator page
    When I do not enter any value in the "a", "b", and "c" input fields
    And I click on the button
    Then I should see an error message indicating that all fields are required
