@regression
Feature: Personal Details

  As an admin I want to edit employee personal details after creation.

  Background:
    Given I am logged in
    And I am on the Add Employee page

  Scenario: Fill all personal details fields
    When I fill all personal details: otherId="EMP001", dob="1990-05-15", marital="Single", gender="Male", nationality="American", license="DL123456", licExp="2028-06-01", nickname="Jay", military="No", smoker="No"
    And I click the Personal Details Save button
    Then I should see "Successfully Saved" toast

  Scenario: Invalid date format
    When I enter an invalid birthdate "1990/05/15"
    Then I should see the date format error

  Scenario: License number too long
    When I enter a license number "T09876143534534535345345345231341413413423556476" longer than 30 chars
    Then I should see the character limit error
