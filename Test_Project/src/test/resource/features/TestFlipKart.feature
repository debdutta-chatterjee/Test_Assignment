Feature: FlipKart Add To Cart
@E2E
  Scenario Outline: Product price validation during checkout
    Given Uer is at the Flipkart home page
    When User searched for <ProductName> in the search section
    And User Selects the <ProductIndex> th mobile for checkout
    Then User navigates to cart and validates the price
    And User places order and navigate to order page

    Examples: 
      | ProductName | ProductIndex |
      | Mobile      |            6 |
