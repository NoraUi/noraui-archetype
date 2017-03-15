@LoginLogout
Feature: Test of ${targetApplication.toUpperCase()} constructors portal authentication

	Scenario Outline: Login/Logout on ${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)} constructors portal
    Given '${targetApplication.toUpperCase()}_HOME' is opened.
    Then The ${targetApplication.toUpperCase()} login page is displayed
		
    When I log in to ${targetApplication.toUpperCase()} as '<login>' '<password>'
    When I log out of ${targetApplication.toUpperCase()}
		
    And I go back to '${targetApplication.toUpperCase()}_HOME'
		
	Examples:
	  #DATA
	  |id|login|password|
    #END