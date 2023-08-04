Feature: Validate Received documents page for all roles

  Background:
    Given User is on Docuport login page

  @smoke
  Scenario Outline: Validate Received documents page for client, employee and supervisor

    When user enters credentials "<username>" and "<password>"
    And user clicks on "Received docs" button
    Then validate if  "Search" button is displayed on Receive docs page
    Then validate if "Download" button is displayed
    And validate if Receive docs header is displayed
    When user clicks on "My uploads" button
    When validate if "Search" button on My uploads page  is displayed
    Then validate if on My uploads page "Download" button is displayed
    And validate if My uploads is displayed

    Examples:
      | username                  | password |
      | b1g3_client@gmail.com     | Group3   |
      | b1g3_advisor@gmail.com    | Group3   |
      | b1g3_supervisor@gmail.com | Group3   |
      | b1g3_employee@gmail.com   | Group3   |