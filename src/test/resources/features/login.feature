@SetupDriver
@Login
Feature: Login
  As a user
  I want to login the app
  In order to view all the information

  @GoHomePage
  Scenario: Navigate to the home page
    Given I am at the home page