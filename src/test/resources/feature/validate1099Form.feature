Feature: validate 1099 link
  @smoke
  Scenario: Validate
    Given User is on Docuport login page
    When user enters credentions
      | username | b1g3_advisor@gmail.com |
      | password | Group3        |
    When user should see home page
    When user should clicks on 1099 From button
    Then user validates 1099 Form button isDisplayed
