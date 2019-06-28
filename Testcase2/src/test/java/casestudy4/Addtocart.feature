
Feature: Addtocart
  

  @FailStage
  Scenario: FailTest 
    Given Alex is registered with TextMe App
    When Alex search for a product like headphone
    And Try to proceed to payment without adding anyitem
    Then TestMe App didn't displayed cart icon
    
  @PassStage @confirm
  Scenario: PassTest
    Given Alex is registered with TextMe
    When Alex searches a product like headphones
    And Selects the product from product page and adds to cart
    Then Product is added to cart and icon is displayed
    And   Checks Product Quantity and Pice is confirmed
    Then Alex proceed to payment page and does payment
    And Order page is dispalyed
    
    

  