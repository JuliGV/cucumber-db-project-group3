Feature: Docuport Login Logout Feature

  Scenario:  Login as a Client
    Given User is on Docuport login page
    When  user enters user for client
    And user enters password for client
    And user clicks login button
    Then user should see home page for client



    Scenario: Login as a employee
      Given User is on Docuport login page
      When  user enters user for employee
      And user enters password for employee
      And user clicks login button
      Then user should see home page for employee