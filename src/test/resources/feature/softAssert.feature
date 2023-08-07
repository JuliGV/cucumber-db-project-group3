Feature: sample feature to demo soft assertion

@smoke
  Scenario: sample scenario for soft assertion
    Given User is on Docuport login page
    When user enters credentions

      | username | b1g3_client@gmail.com |
      | password | Group3                |
  And user validates if pop-up is visible
  And user chooses account from dropdown "test2"
  Then user should see home page for client