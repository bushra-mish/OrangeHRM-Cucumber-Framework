@regression
Feature: Employee List

  As an admin I want to view and verify the employee list table.

  Background:
    Given I am logged in
    And I navigate to the Employee List page

  Scenario: Verify table row count and columns
    Then the table should show 50 rows
    And the table should have these columns:
      | Employee Id       |
      | Name              |
      | Job Title         |
      | Employment Status |
      | Sub Unit          |
      | Cost Center       |
      | Location          |
      | Supervisor        |
