Feature: Scenario outline practice

  Scenario Outline: Google search for capital cities
    Given user is on Google search page
    When user searches for the "<country>"
    Then user should see the "<capital>" in the result
    Examples:
      | country     | capital    |
      | Ukraine     | Kyiv       |
      | Afghanistan | Kabul      |
      | USA         | Washington |
      | Turkey      | Ankara     |
