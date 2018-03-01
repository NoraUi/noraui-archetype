#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Oraganization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * 
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package ${package}.utils;

import com.github.noraui.utils.Messages;

public class ${robotName}Messages extends Messages {

    /**
     * Technical messages
     */
    public static final String ${robotName.toUpperCase()}_ERROR_MESSAGE_DEFAULT = "Erreur dans le code ${robotName} : ";
    public static final String ${robotName.toUpperCase()}_ERROR_MESSAGE_APPLICATION_NOT_IMPLEMENTED = ${robotName.toUpperCase()}_ERROR_MESSAGE_DEFAULT + "l'application « %s » n'est pas implementée dans ${robotName}.";
    public static final String SCENARIO_ERROR_MESSAGE_ILLEGAL_ARGUMENT = Messages.getMessage(Messages.FAIL_MESSAGE_DEFAULT) + "les arguments autorisés sont ${symbol_escape}"ACT-${symbol_escape}", ${symbol_escape}"DPS-${symbol_escape}" et ${symbol_escape}"ALT-${symbol_escape}"";

    /**
     * Functional fail messages.
     */
    //public static final String FAIL_MESSAGE_ = "....";

    /**
     * Functional fail messages with parameters.
     */
    //public static final String FAIL_MESSAGE_ = "...... « %s » ....";
    //public static final String FAIL_MESSAGE_ = "...... « %s » .... %s.";

    /**
     * Constructor is useless because all attributes are static
     */
    private ${robotName}Messages() {
    }

}
