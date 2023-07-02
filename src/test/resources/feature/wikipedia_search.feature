Feature: Wikipedia Search Functionality Title Verification


  Scenario Outline: Validate wikipedia title,header,image header
    Given User is on Wikipedia home page
    When User types name in the wiki search box
      | Steve Jobs |
    And User clicks wiki search button
    Then User sees Steve Jobs is in the "<wiki title>","<wiki search box>","<image header>"
    Examples:
      | wiki title             | wiki search box | image header |
      | Steve Jobs - Wikipedia | Steve Jobs      | Steve Jobs   |

