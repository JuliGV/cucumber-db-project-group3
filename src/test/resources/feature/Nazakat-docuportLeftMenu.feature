Feature: Validate left menu for all roles

  Background:

    Given User is on Docuport login page
@smoke
  Scenario Outline: Validate left menu for all roles
    When user enters credentials "<username>" and "<password>" for each role
    When user clicks on "Log in" button
    And user should see home page
    Then validate all text for left menu links

      | advisor         | client        | supervisor      | employee        |
      | Home            | Home          | Home            | Home            |
      | Received docs   | Received docs | Received docs   | Received docs   |
      | My uploads      | My uploads    | My uploads      | My uploads      |
      | Clients         | Invitations   | Clients         | Clients         |
      | Invitations     |               | Users           | Users           |
      | Users           |               | Leads           | Bookkeeping     |
      | Leads           |               | Bookkeeping     | 1099 Form       |
      | Bookkeeping     |               | 1099 Form       | Reconciliations |
      | 1099 Form       |               | Reconciliations |                 |
      | Reconciliations |               |                 |                 |

    Examples:
      | username                  | password |
      | b1g3_advisor@gmail.com    | Group3   |
      | b1g3_client@gmail.com     | Group3   |
      | b1g3_supervisor@gmail.com | Group3   |
      | b1g3_employee@gmail.com   | Group3   |

