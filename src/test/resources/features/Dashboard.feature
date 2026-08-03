@regression
Feature: Dashboard Menu

  As an admin I want to verify the dashboard menu items.

  Background:
    Given I am logged in

  @smoke
  Scenario: Verify dashboard menu items
    Then the dashboard menu should contain:
      | Admin           |
      | PIM             |
      | My Info         |
      | Discipline      |
      | Reports Catalog |
      | More            |
      | Maintenance     |
