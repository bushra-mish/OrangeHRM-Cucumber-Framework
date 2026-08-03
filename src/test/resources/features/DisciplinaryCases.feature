@regression
Feature: Disciplinary Cases

  As an admin I want to create and verify disciplinary cases.

  Background:
    Given I am logged in
    And I go to Discipline > Disciplinary Cases

  Scenario: Verify modal labels
    Then I click the add button
    And the modal should be visible
    Then the modal labels should be:
      | Employee Name * |
      | Case Name *     |
      | Description     |

  Scenario Outline: Create a disciplinary case
    Then I click the add button
    And the modal should be visible
    When I enter case: employee="<Employee>", name="<Case>", description="<Description>"
    And I click Save on the case
    And I save the case via footer button
    Then the case "<Case>" should appear in the table

    Examples:
      | Employee   | Case           | Description              |
      | John Doe   | Late arrival   | Repeated late attendance |
      | Alice John | Dress code     | Violated dress policy    |

  Scenario: Missing required fields
    Then I click the add button
    When I enter case: employee="", name="", description=""
    And I click Save on the case
    Then the modal should be visible
