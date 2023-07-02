Feature: Google search functionality Title Verification
  User Strpry: As a user,when I am on the Google search page
  I should be able to search whatever and see relevant information


  Scenario:
    Given user is Google search page
    When user types Loop Academy in the google search box and clocks enter
    Then user should see Loop Academy - Google Search in the google title


  Scenario: Search functionality result title verification
    Given user is on Google search page
    When user types "Loop Academy" in the google search box and click enter
    Then User should see "Loop Academy - Google Search" search is in the google title