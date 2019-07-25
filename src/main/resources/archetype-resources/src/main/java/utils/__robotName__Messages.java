#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 *
 * @author Nicolas HALLOUIN
 * @author Stéphane GRILLON
 */
package ${package}.utils;

import com.github.noraui.utils.Messages;

public class ${robotName}Messages extends Messages {

    /**
     * Technical messages
     */
    public static final String ${robotName.toUpperCase()}_ERROR_MESSAGE_DEFAULT = "${robotName.toUpperCase()}_ERROR_MESSAGE_DEFAULT";
    public static final String ${robotName.toUpperCase()}_ERROR_MESSAGE_APPLICATION_NOT_IMPLEMENTED = NORAROBOT_ERROR_MESSAGE_DEFAULT + "${robotName.toUpperCase()}_ERROR_MESSAGE_APPLICATION_NOT_IMPLEMENTED";

	/**
     * Generic messages.
     */
    public static final String HELLO = "HELLO";
    
    /**
     * Functional fail messages.
     */
    public static final String USER_WAS_ALREADY_LOGOUT = "USER_WAS_ALREADY_LOGOUT";
	
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
