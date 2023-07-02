Feature: Passing multiple parameters to the same step


  Scenario: Searching multiple items
    Given user is on Google search page
    Then user searches the following items
      | loop academy |
      | java         |
      | selenium     |
      | sql          |
      | cucumber bdd |