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