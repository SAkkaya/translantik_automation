
Feature: As a user, I should be able to log in

	#*_1-All users can log in by using valid credentials (We have 3 types of user such as sales manager, store manager, truck driver)._*

	Scenario Outline: Login with valid credentials for driver, store manager, sales manager "<userType>" with "<submitType>"
		
		    Given the user is on the login page
		    When the user logged in as "<userType>" with "<submitType>"
		    Then the user should be able to login
		    And the user should see the title contains "Dashboard"
		
		    Examples:
				| userType      | submitType   |
				| driver       | submitButton |
				| driver        | enterButton  |
				| sales manager | submitButton |
				| sales manager | enterButton  |
				| store manager | submitButton |
				| store manager | enterButton  |


	Scenario Outline: Login with invalid credentials

		Given the user is on the login page
		When the user logged in as "<username>" and "<password>"
		Then the user should see the message "Invalid user name or password."

		Examples:
			| username        | password    |
			| user1           | UserUser    |
			| user150         | UserUser123 |
			| storemanager85  | UserUser    |
			| storemanager    | UserUser123 |
			| salesmanager101 | UserUser12  |
			| salesmanager80  | UserUser123 |


	Scenario Outline: Login with empty username or password
		Given the user is on the login page
		When the user logged in as "<username>" and "<password>"
		Then the user should see the message "Please fill in this field."

		Examples:
			| username        | password    |
			| user1           |             |
			|                 | UserUser123 |
			| storemanager85  |             |
			|                 | UserUser123 |
			| salesmanager101 |             |
			|                 | UserUser123 |

      Scenario Outline: Navigating to Dashboard Menus
        Given the user logged in as "<userType>"
        Then "<userType>" should lands on the "<Page>" page after successful login

        Examples:
          | userType      | Page            |
          | driver        | Quick Launchpad |
          | sales manager | Dashboard       |
          | store manager | Dashboard       |
