#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
# ${robotName} for ${targetApplicationId.toUpperCase()}

NoraUi, for NOn-Regression Automation for User Interfaces, is a Java framework based on Selenium, Cucumber and Gherkin stack to create GUI testing projects that can be included in the continuous integration chain of single/multi applications web solution builds.
It ensures applications non-regression throughout their lifes taking into account code evolutions and acceptance of defined business client criterias.

# Exploitation

* On "Goal" of Build part:  clean test javadoc:javadoc -Dcucumber.options="--tags '@LoginLogout'" -Pjavadoc,preIC,scenarioInitiator,ci,unit-tests,postIC,analyze -Dmaven.test.failure.ignore=true sonar:sonar
* More information on https://noraui.github.io

# LICENSE

* ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
* ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
