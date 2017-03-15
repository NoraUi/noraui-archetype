#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.main;

import ${package}.utils.${robotName}Context;

import noraui.main.ScenarioInitiator;

public class ScenarioInitiatorRunner {

    public static void main(String[] args) {
        ${robotName}Context.getInstance().initializeEnv("${robotName.toLowerCase()}.properties");
        new ScenarioInitiator().start(args);
    }

}
