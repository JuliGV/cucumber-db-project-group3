Feature: Validate rows per page in the leads menu for avisor

@smoke
  Scenario: Validate
    Given User is on Docuport login page
    When user enters credentions
      | username | b1g3_advisor@gmail.com |
      | password | Group3                 |
    When user should see home page
    When user clicks on "Leads" button
    Then user validates that Rows Per Page shows by default 10
    When user change Rows Per Page to 5
    Then user validates that Rows Per Page shows 5
    When user clicks on "Users" button
    Then user validates that Rows Per Page shows by default 10
    When user change Rows Per Page to 5
    Then user validates that Rows Per Page shows 5
