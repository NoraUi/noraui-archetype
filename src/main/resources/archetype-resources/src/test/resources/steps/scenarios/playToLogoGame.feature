@playToLogoGame
Feature: playToLogoGame (Scenario that 1st sample. is it a scenario that plays on the game of logos.)

  Scenario Outline:  Scenario that 1st sample. is it a scenario that plays on the game of logos.

    Given I check that 'player' '<player>' is not empty
    Given I check that all brands '<DataJson>' are not prohibited

    Given 'LOGOGAME_HOME' is opened
    Then The LOGOGAME home page is displayed

    Then I play with 'amazon'
    Then I add '8' random brand
    And I check alert message

    Then I play with my input file '<DataJson>'
    Then I valide in LOGOGAME
    Then I save score

    And I go back to 'LOGOGAME_HOME'

  Examples:
    #DATA
    |id|player|DataJson|
    #END