Feature: Docuport Login Logout Feature

  Background: will run for before each scenarios
    Given User is on Docuport login page


  Scenario:   Login as a Client
    When  user enters user for client
    And user enters password for client
    And user clicks login button
    Then user should see home page for client



  Scenario: Login as a employee
    When  user enters user for employee
    And user enters password for employee
    And user clicks on "Log in" button
    Then user should see home page for employee


  Scenario: Login as a advisor
    When  user enters user for advisor
    And user enters password for advisor
    And user clicks on "Log in" button
    Then user should see home page for advisor

  @smoke
  Scenario: Login as a admin
    When  user enters user for admin
    And user enters password for admin
    And user clicks on "Log in" button
    Then user should see home page for admin


  Scenario: Login as a client Map practice
    When user enters credentions
      | username | b1g3_client@gmail.com |
      | password | Group3                |
    Then user should see home page for client


  Scenario Outline: Login as a client Map practice
    When user enters credentials "<username>" and "<password>"
    Then user should see home page
    Examples:
      | username                  | password |
      | b1g3_client@gmail.com     | Group3   |
      | b1g3_advisor@gmail.com    | Group3   |
      | b1g3_supervisor@gmail.com | Group3   |
      | b1g3_employee@gmail.com   | Group3   |


