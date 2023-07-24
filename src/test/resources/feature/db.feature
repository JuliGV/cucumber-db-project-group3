Feature: As a data consumer,I want the department information store in postgers DB correctly in department table

  Background:
    Given Establish database connection
@db
  Scenario: Verify DB department's table column
    When Execute query to get all columns from "departments"
    Then verify the below column sare listed in result for
      | tax                  |
      | bookkeeping          |
      | payroll              |
      | consultancy-services |



