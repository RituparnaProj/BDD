Feature: Login functionality for Flipcart E-commerce site


  Background:
    Given I am on the flipcart login page

  Scenario Outline: Unsuccessful login with flipcart
    Given I have entered invalid "<username>" and "<password>"
    When I click on the login button
    Then I should see the error message
    Examples:
      | username | password |
      | abc      | abc      |
