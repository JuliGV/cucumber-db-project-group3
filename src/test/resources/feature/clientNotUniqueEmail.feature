Feature: Validate if each client users can have the same email

  Scenario Outline: Validate if clients can have the same email

    Given User is on Docuport login page
    When user enters credentials "<username>" and "<password>" for each role
    When user clicks on "Log in" button
    When user is on "Clients" page
    When user click on create new client button and choose "Personal" option
    When user creates new client with test@gmail.com email
    And user creates one more client with the same  email test@gmail.com
    Then validate if both clints have the same email "test@gmail.com"

    Examples:
      | username                  | password |
      | b1g3_advisor@gmail.com   | Group3   |
#      | b1g3_supervisor@gmail.com | Group3   |
#      | b1g3_employee@gmail.com   | Group3   |