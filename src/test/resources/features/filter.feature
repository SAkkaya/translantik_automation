
Feature: As a user, I should be able to log in

  Scenario Outline:  default hidden manage filter <userType>

    Given the user logged in as "<userType>"
    When the user navigate to "Fleet""Vehicles"
    Then Manage filter should be hidden as default

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


  Scenario Outline:  default hidden manage filter <userType>

    Given the user logged in as "<userType>"
    When the user navigate to "Fleet""Vehicles"
    And the user clicks on the filter button
    Then Manage filter options should be displayed

    Examples:
      | userType      |
      | driver        |
      | store manager |
      | sales manager |


    Scenario Outline:  default hidden manage filter <userType>

      Given the user logged in as "<userType>"
      When the user navigate to "Fleet""Vehicles"
      And the user clicks on the filter button
     Then Manage filter options should be displayed
      And the user click on manageFilterButton
      Then User can apply filtering for each of the "<dataColumns>"  on the page


      Examples:
        | userType      | dataColumns         |
        | driver        | Driver              |
        | driver        | Tags                |
#        | driver        | Seat Number         |
#        | driver        | First Contract Date |
#        | store manager | Driver              |
#        | store manager | Tags                |
#        | store manager | Seat Number         |
#        | store manager | First Contract Date |
#        | sales manager | Driver              |
#        | sales manager | Tags                |
#        | sales manager | Seat Number         |
#        | sales manager | First Contract Date |



  Scenario Outline: using reset button
    Given the user logged in as "<userType>"
    When the user navigate to "Fleet""Vehicles"
    And the user clicks on the filter button
    And the user click on manageFilterButton
    And select all boxes
    Then all check boxes are selected
    When the user click on reset button
    Then User can  remove all filterings by using the reset button
    Examples:
      | userType     |
      | driver       |
      | sales manager |
      | store manager |

@wip

  Scenario Outline:  multiple filtering of columns
    Given the user logged in as "<userType>"
    When the user navigate to "Fleet""Vehicles"
    And the user clicks on the filter button
    And the user click on manageFilterButton
    And the user click on multiple options
    When the user sends values for the Licence Plate and Tags
    Then the application should be able to support multiple filtering of columns



  Examples:
    | userType      |
    | driver        |
    | sales manager |
    | store manager |