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

  @PassTestNoExecutionControl
  Scenario Outline: Stop test execution if more than PassTestExecutionControlNum test failed
    Given user is on home page and testdata present in "<TestData>"
    When login using the credentials
    Then user should be able to login successfully

    Examples:
      | TestData                                           |
      | Mutiple/PassTestNoExecutionControl/Scenario01.json |
      | Mutiple/PassTestNoExecutionControl/Scenario02.json |
      | Mutiple/PassTestNoExecutionControl/Scenario03.json |
      | Mutiple/PassTestNoExecutionControl/Scenario04.json |
      | Mutiple/PassTestNoExecutionControl/Scenario05.json |
      | Mutiple/PassTestNoExecutionControl/Scenario06.json |
      | Mutiple/PassTestNoExecutionControl/Scenario07.json |
      | Mutiple/PassTestNoExecutionControl/Scenario08.json |
      | Mutiple/PassTestNoExecutionControl/Scenario09.json |
      | Mutiple/PassTestNoExecutionControl/Scenario10.json |
      | Mutiple/PassTestNoExecutionControl/Scenario11.json |
      | Mutiple/PassTestNoExecutionControl/Scenario12.json |
      | Mutiple/PassTestNoExecutionControl/Scenario13.json |
      | Mutiple/PassTestNoExecutionControl/Scenario14.json |
      | Mutiple/PassTestNoExecutionControl/Scenario15.json |
      | Mutiple/PassTestNoExecutionControl/Scenario16.json |
      | Mutiple/PassTestNoExecutionControl/Scenario17.json |
      | Mutiple/PassTestNoExecutionControl/Scenario18.json |
      | Mutiple/PassTestNoExecutionControl/Scenario19.json |
      | Mutiple/PassTestNoExecutionControl/Scenario20.json |
      | Mutiple/PassTestNoExecutionControl/Scenario21.json |
      | Mutiple/PassTestNoExecutionControl/Scenario22.json |
      | Mutiple/PassTestNoExecutionControl/Scenario23.json |
      | Mutiple/PassTestNoExecutionControl/Scenario24.json |
      | Mutiple/PassTestNoExecutionControl/Scenario25.json |
      | Mutiple/PassTestNoExecutionControl/Scenario26.json |
      | Mutiple/PassTestNoExecutionControl/Scenario27.json |
      | Mutiple/PassTestNoExecutionControl/Scenario28.json |
      | Mutiple/PassTestNoExecutionControl/Scenario29.json |
      | Mutiple/PassTestNoExecutionControl/Scenario30.json |
