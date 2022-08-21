#Author: abhishek.kadavil@gmail.com

@FirstTimeOrder
Feature: First time credit card order
  I want to test first time credit card order

  @FirstTimeOrder_Scenario1
  Scenario Outline: Credit card payment with one item
    Given user is on home page and testdata present in "<TestData>"
    When login using the credentials
    Then user should be able to login successfully
    And add item to cart
    And checkout the cart
    And add billing address
    And select shipping method
    And select payment method
    And confirm order
    Then order should be placed successfully

    Examples:
      | TestData                       |
      | FirstTimeOrder/Scenario01.json |
      | FirstTimeOrder/Scenario02.json |
      | FirstTimeOrder/Scenario03.json |
      | FirstTimeOrder/Scenario04.json |