@TRANS-553
Feature: As a user, I should be able to log in

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#*_1-All users can log in by using valid credentials (We have 3 types of user such as sales manager, store manager, truck driver)._*
	#
	#2-"Invalid username or password." should be displayed for invalid credentials
	#3- "Please fill in this field" message should be displayed if the password or username is empty
	#4- Driver should land on "Quick LunchPad" page after successful login
	#5- Sales Manager/ Store Manager should lands on the "Dashboard" page after successful login
	@TRANS-549 @EU5GR12
	Scenario Outline:  Login with valid credentials for driver, store manager, sales manager "<userType>" with "<submitType>"
		            Given the user is on the login page
				    When the user logged in as "<userType>" with "<submitType>"
				    Then the user should see the title contains "Dashboard"
				
				    Examples:
						| userType      | submitType   |
						| driver       | submitButton |
						| driver        | enterButton  |
						| sales manager | submitButton |
						| sales manager | enterButton  |
						| store manager | submitButton |
						| store manager | enterButton  |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#_1-All users can log in by using valid credentials (We have 3 types of user such as sales manager, store manager, truck driver)._
	#
	#*2-"Invalid username or password." should be displayed for invalid credentials*
	# 3- "Please fill in this field" message should be displayed if the password or username is empty
	# 4- Driver should land on "Quick LunchPad" page after successful login
	# 5- Sales Manager/ Store Manager should lands on the "Dashboard" page after successful login
	@TRANS-550 @EU5GR12
	Scenario Outline:  Login with invalid credentials
		        Given the user is on the login page
				When the user logged in as "<username>" and "<password>"
				Then the user should see the message "Invalid user name or password."
		
				Examples:
					| username        | password    |
					| user1           | UserUser1   |
					| user150         | UserUser123 |
					| storemanager85  | UserUser    |
					| storemanager    | UserUser123 |
					| salesmanager101 | UserUser12  |
					| salesmanager80  | UserUser123 |	

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#_1-All users can log in by using valid credentials (We have 3 types of user such as sales manager, store manager, truck driver)._
	#
	#2-"Invalid username or password." should be displayed for invalid credentials
	# *3- "Please fill in this field" message should be displayed if the password or username is empty*
	# 4- Driver should land on "Quick LunchPad" page after successful login
	# 5- Sales Manager/ Store Manager should lands on the "Dashboard" page after successful login
	@TRANS-551 @EU5GR12
	Scenario Outline: Login with empty username or password
		    	Given the user is on the login page
				When the user logged in as "<username>" and "<password>"
				Then the user should see the message "Please fill in this field."
		
				Examples:
					| username        | password    |
					|                 | UserUser123 |
					| user1           | 	        |
					| storemanager85  |             |
					|                 | UserUser123 |
					| salesmanager101 |             |
					|                 | UserUser123 |
					|                 |             |

	#{color:#00875a}*User Story :* {color}
	#
	#As a user, I should be able to log in
	#
	# 
	#
	#{color:#ff8b00}*_Acceptance Criteria:_*{color}
	#
	#_1-All users can log in by using valid credentials (We have 3 types of user such as sales manager, store manager, truck driver)._
	#
	#2-"Invalid username or password." should be displayed for invalid credentials
	# 3- "Please fill in this field" message should be displayed if the password or username is empty
	# *4- Driver should land on "Quick LunchPad" page after successful login*
	# *5- Sales Manager/ Store Manager should lands on the "Dashboard" page after successful login*
	@TRANS-552 @EU5GR12
	Scenario Outline: Navigating to Dashboard Menus
				Given the user is on the login page
		        When the user logged in as "<userType>"
		        Then the user should lands on the "<Page>" page
		
		        Examples:
		          | userType      | Page            |
		          | driver        | Quick Launchpad |
		          | sales manager | Dashboard       |
		          | store manager | Dashboard       |