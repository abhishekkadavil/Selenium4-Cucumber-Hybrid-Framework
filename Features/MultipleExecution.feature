#Author: abhishek.kadavil@gmail.com

@AllMutiple
Feature: Login
  I want to test the login scenario by executing multiple times

  @LoginMutiple
  Scenario Outline: login different users
    Given user is on home page and testdata present in "<TestData>"
    When login using the credentials
    Then user should be able to login successfully

    Examples:
    | TestData                             |
    | Mutiple/LoginMutiple/Scenario01.json |
    | Mutiple/LoginMutiple/Scenario02.json |
    | Mutiple/LoginMutiple/Scenario03.json |
    | Mutiple/LoginMutiple/Scenario04.json |
    | Mutiple/LoginMutiple/Scenario05.json |
    | Mutiple/LoginMutiple/Scenario06.json |
    | Mutiple/LoginMutiple/Scenario07.json |
    | Mutiple/LoginMutiple/Scenario08.json |

  @PlaceOrderMutiple1
  Scenario Outline: Credit card payment with one item
    Given user is on home page and testdata present in "<TestData>"
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
    Examples:
      | TestData                                  |
      | Mutiple/PlaceOrderMutiple/Scenario01.json |
      | Mutiple/PlaceOrderMutiple/Scenario02.json |
      | Mutiple/PlaceOrderMutiple/Scenario03.json |
      | Mutiple/PlaceOrderMutiple/Scenario04.json |
