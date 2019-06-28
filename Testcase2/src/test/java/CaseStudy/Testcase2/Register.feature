@tag
Feature: Registration
  

  @tag1
  Scenario: Scuccessful Registration
    Given User is in the registration page
   When User enters the sign credentials
    Then User clicks the register button
    And User is directed to login page

  