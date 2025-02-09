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

  @PassPercentageExecutionControl
  Scenario Outline: Stop test execution if more than 50% test failed
    Given user is on home page and testdata present in "<TestData>"
    When login using the credentials
    Then user should be able to login successfully

    Examples:
      | TestData                                               |
      | Mutiple/PassPercentageExecutionControl/Scenario01.json |
      | Mutiple/PassPercentageExecutionControl/Scenario02.json |
      | Mutiple/PassPercentageExecutionControl/Scenario03.json |
      | Mutiple/PassPercentageExecutionControl/Scenario04.json |
      | Mutiple/PassPercentageExecutionControl/Scenario05.json |
      | Mutiple/PassPercentageExecutionControl/Scenario06.json |
      | Mutiple/PassPercentageExecutionControl/Scenario07.json |
      | Mutiple/PassPercentageExecutionControl/Scenario08.json |
      | Mutiple/PassPercentageExecutionControl/Scenario09.json |
      | Mutiple/PassPercentageExecutionControl/Scenario10.json |
      | Mutiple/PassPercentageExecutionControl/Scenario11.json |
      | Mutiple/PassPercentageExecutionControl/Scenario12.json |
      | Mutiple/PassPercentageExecutionControl/Scenario13.json |
      | Mutiple/PassPercentageExecutionControl/Scenario14.json |
      | Mutiple/PassPercentageExecutionControl/Scenario15.json |
      | Mutiple/PassPercentageExecutionControl/Scenario16.json |
      | Mutiple/PassPercentageExecutionControl/Scenario17.json |
      | Mutiple/PassPercentageExecutionControl/Scenario18.json |
      | Mutiple/PassPercentageExecutionControl/Scenario19.json |
      | Mutiple/PassPercentageExecutionControl/Scenario20.json |
      | Mutiple/PassPercentageExecutionControl/Scenario21.json |
      | Mutiple/PassPercentageExecutionControl/Scenario22.json |
      | Mutiple/PassPercentageExecutionControl/Scenario23.json |
      | Mutiple/PassPercentageExecutionControl/Scenario24.json |
      | Mutiple/PassPercentageExecutionControl/Scenario25.json |
      | Mutiple/PassPercentageExecutionControl/Scenario26.json |
      | Mutiple/PassPercentageExecutionControl/Scenario27.json |
      | Mutiple/PassPercentageExecutionControl/Scenario28.json |
      | Mutiple/PassPercentageExecutionControl/Scenario29.json |
      | Mutiple/PassPercentageExecutionControl/Scenario30.json |
