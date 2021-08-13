Feature: As a user, I should be able to log out

  Scenario Outline: Log out option under the user icon <userType>
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    And the user click on user icon
    Then the user should see the Logout Button

    Examples:
      | userType      | tab                | module                |
      | driver        | Fleet              | Vehicles Model        |
      | driver        | Customers          | Contacts              |
      | driver        | Activities         | Calendar Events       |
      | driver        | System             | Jobs                  |
      | sales manager | Dashboards         | Dashboard             |
      | sales manager | Fleet              | Vehicles              |
      | sales manager | Customers          | Accounts              |
      | sales manager | Sales              | Opportunities         |
      | sales manager | Marketing          | Campaigns             |
      | sales manager | Activities         | Calendar Events       |
      | sales manager | System             | Jobs                  |
      | sales manager | Reports & Segments | Reports               |
      | store manager | Fleet              | Vehicle Costs        |
      | store manager | Sales              | Opportunities         |
      | store manager | Marketing          | Email Campaigns       |
      | store manager | Customers          | Contacts              |
      | store manager | Activities         | Calls                 |
      | store manager | Reports            | Manage Custom Reports |
      | store manager | System             | Menus                 |


  Scenario Outline:  Land on the "Log in" page after successfully logged out <userType>
    Given the user logged in as "<userType>"
    When the user navigates to "<tab>" "<module>"
    And the user click on user icon
    Then the user should see the Logout Button
    When the user click on Logout button
    Then the user should be able to see the Login Page
    When the user click on goBack arrow
    Then the user should be able to see the Login Page

    Examples:
      | userType      | tab                | module                |
      | driver        | Fleet              | Vehicles Model        |
      | driver        | Customers          | Contacts              |
      | driver        | Activities         | Calendar Events       |
      | driver        | System             | Jobs                  |
      | sales manager | Dashboards         | Dashboard             |
      | sales manager | Fleet              | Vehicles              |
      | sales manager | Customers          | Accounts              |
      | sales manager | Sales              | Opportunities         |
      | sales manager | Marketing          | Campaigns             |
      | sales manager | Activities         | Calendar Events       |
      | sales manager | System             | Jobs                  |
      | sales manager | Reports & Segments | Reports               |
      | store manager | Fleet              | Vehicle Costs        |
      | store manager | Sales              | Opportunities         |
      | store manager | Marketing          | Email Campaigns       |
      | store manager | Customers          | Contacts              |
      | store manager | Activities         | Calls                 |
      | store manager | Reports            | Manage Custom Reports |
      | store manager | System             | Menus                 |
