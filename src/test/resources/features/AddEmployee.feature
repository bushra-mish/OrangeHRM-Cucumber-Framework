@regression
Feature: Add Employee

  As an admin I want to add employees so that they appear in the system.

  Background:
    Given I am logged in
    And I am on the Add Employee page

  @smoke
  Scenario: Add an employee with first and last name
    When I enter first name "John" and last name "Doe"
    And I click Save
    Then the employee "John Doe" should be saved

  Scenario Outline: Add employees with location and login
    When I enter first name "<First>" and last name "<Last>"
    And I select location "<Location>"
    And I toggle Create Login Details
    And I enter username "<Username>" and password "<Password>"
    And I click Save
    Then the employee "<First> <Last>" should be saved

    Examples:
      | First  | Last    | Location                    | Username  | Password    |
      | Alice  | Johnson | Australian Regional HQ      | alice.j   | Test@12345  |
      | Bob    | Smith   | Canadian Development Center | bob.s     | Test@12345  |

  Scenario Outline: Add employees with middle name
    When I enter first name "<First>", middle name "<Middle>", and last name "<Last>"
    And I click Save
    Then the employee "<First> <Last>" should be saved

    Examples:
      | First | Middle | Last  |
      | James | T      | Kirk  |
      | Jean  | L      | Picard|
