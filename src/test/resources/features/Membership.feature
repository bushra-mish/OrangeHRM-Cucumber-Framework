@regression
Feature: Membership

  As an admin I want to add a membership to an employee profile.

  Background:
    Given I am logged in
    And I go to My Info > Memberships

  Scenario: Add a new membership
    When I click the add membership button
    And I select membership type "Gym Membership"
    And I select paid by "Individual"
    And I enter fee "1500"
    And I select currency "Albanian Lek"
    And I set commence date to "2025-3-10"
    And I set renewal date to "2025-9-10"
    Then I click the membership Save button
    And the membership table should be visible
