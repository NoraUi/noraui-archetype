@${targetApplicationName}
Feature: ${targetApplicationName} (Scenario that plays logo game.) 

	Scenario Outline:  Scenario that plays logo game.
	
    Given I check that player '<player>' is not empty.
    
    Given '${targetApplicationId.toUpperCase()}_HOME' is opened.
    Then The ${targetApplicationId.toUpperCase()} portal is displayed
    
    Then I play with 'amazon'
    Then I add '8' random brand
    And I check alert message
    
    Then I play with my input file '<DataJson>'
    Then I valide in ${targetApplicationId.toUpperCase()}
    Then I save score

    And I go back to '${targetApplicationId.toUpperCase()}_HOME'
		
	Examples:
	  #DATA
	  |id|player|DataJson|
    #END