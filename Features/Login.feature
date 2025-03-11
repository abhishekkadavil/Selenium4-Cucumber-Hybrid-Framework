#Author: abhishek.kadavil@gmail.com

@All @Login
Feature: Login
 I want to test the login feature

 @Login_Scenario1
 Scenario: login with valid user
  Given user is on home page and testdata present in "Login/Scenario01.json"
  When login using the credentials
  Then user should be able to login successfully

 @Login_Scenario2
 Scenario: login with invalid user
  Given user is on home page and testdata present in "Login/Scenario02.json"
  When login using the credentials
  Then invalid user error should appear

 @Login_Scenario3
 Scenario: failed test case
  Given user is on home page and testdata present in "Login/Scenario03.json"
  When login using the credentials
  Then "invalid user error1" message should appear

 @Login_Scenario4
 Scenario: login exception test case
  Given user is on home page and testdata present in "Login/Scenario04.json"
  When login using the credentials
  And add item to cart

 @Login_Scenario5
 Scenario: login with browser in the step
  Given user is on home page in "firefox" browser and testdata present in "Login/Scenario05.json"
  When login using the credentials
  Then user should be able to login successfully