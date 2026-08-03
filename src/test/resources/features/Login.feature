@smoke @regression
Feature: Login

  As a user I want to log in so I can access the HRM dashboard.

  Background:
    Given I am logged in

  @smoke
  Scenario: Successful login
    When I enter a valid username
    And I enter a valid password
    And I click the login button
    Then I should see the dashboard

  Scenario: Login with invalid credentials
    When I enter "wrongUser" as username
    And I enter "wrongPass" as password
    And I click the login button
    Then I should see "Invalid Credentials"

  Scenario: Logo is visible
    Then the logo should be displayed
