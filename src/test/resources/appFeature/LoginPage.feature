Feature: Login page feature
  I want to use this template for my feature file

  Scenario: Login page title
    Given user is on login page
    When user get the title of the page
    Then page title should be "Login - My Store"

  Scenario: Forgot password link
    Given user is on login page
    Then forgot password link should be displayed

  Scenario: Login with correct credentials
    Given user is on login page
    When user enters username "sumitpaliwal08@gmail.com"
    When user enters password "selenium123#"
    And user clicks on Login button
    When user get the title of the page
    Then page title should be "My account - My Store"
