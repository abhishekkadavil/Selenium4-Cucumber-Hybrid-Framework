#Author: abhishek.kadavil@gmail.com

@All @CC
Feature: Credit card payment
  I want to test the credit crad payment feature

  @CC_Scenario1
  Scenario: Credit card payment with one item
    Given user is on home page and testdata present in "CreditCardPaymentFeature/Scenario01.json"
    When login using the credentials
    Then user should be able to login successfully
    And add item to cart
    And checkout the cart
    And select billing address
    And select shipping address
    And select shipping method
    And select payment method
    And confirm order
    Then order should be placed successfully
    #And order can be view in order history
#
  @CC_Scenario2
  Scenario: exception occurred while place order
    Given user is on home page and testdata present in "CreditCardPaymentFeature/Scenario02.json"
    When login using the credentials
    And add item to cart
    And checkout the cart
    And select billing address
    And select shipping address
    And select shipping method
    And select payment method
    And confirm order
    Then order should be placed successfully
