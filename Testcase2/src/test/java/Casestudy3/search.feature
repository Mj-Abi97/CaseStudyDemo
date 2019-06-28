
Feature: Search
  User searches for a product
  Scenario: SearchProduct
    Given User is in Testme app Home page
    And User clicks the sigin icon
    When User enters login credentials in login page
    And User clicks login button and proceed to homepage
    And User searches for a product in search tab
    Then User selects the product
    And Searched product is displayed in product page

 