#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import noraui.application.Application;
import noraui.application.page.Page;
import noraui.utils.Context;

public class ${robotName}Context extends Context {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(${robotName}Context.class);

    public static final String ${targetApplicationId.toUpperCase()}_KEY = "${targetApplicationId}";
    public static final String ${targetApplicationId.toUpperCase()}_HOME = "${targetApplicationId.toUpperCase()}_HOME";
    public static final String ${targetApplicationId.toUpperCase()}_APP = "${targetApplicationId}.app";

    public static final String GO_TO_${targetApplicationId.toUpperCase()}_HOME = "GO_TO_${targetApplicationId.toUpperCase()}_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME";

    private String ${targetApplicationId}Home; // ${targetApplicationId.toUpperCase()} home url

    /**
     * Constructor is useless because all attributes are static
     */
    private ${robotName}Context() {
        super();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized void initializeRobot(Class clazz) {
        super.initializeRobot(clazz);
        logger.info("${robotName}Context > initializeRobot()");

        // Urls configuration
        ${targetApplicationId}Home = setProperty(${targetApplicationId.toUpperCase()}_KEY, applicationProperties);

        // Selectors configuration
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, ${targetApplicationId.toUpperCase()}_KEY);
 
        
        exceptionCallbacks.put(GO_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, ${targetApplicationId.toUpperCase()}_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeWindowAndSwitchTo", ${targetApplicationId.toUpperCase()}_KEY, ${targetApplicationId.toUpperCase()}_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, "closeAllWindowsAndSwitchTo", ${targetApplicationId.toUpperCase()}_KEY);

        applications.put(${targetApplicationId.toUpperCase()}_KEY, new Application(${targetApplicationId.toUpperCase()}_HOME, ${targetApplicationId}Home));

        Page.setPageMainPackage("${package}.application.pages.");
    }
    
    /**
     * Get context singleton.
     *
     * @return context instance
     */
    public static Context getInstance() {
        if (instance == null || !(instance instanceof ${robotName}Context)) {
            instance = new ${robotName}Context();
        }
        return instance;
    }

    public String get${targetApplicationId.substring(0,1).toUpperCase()}${targetApplicationId.substring(1)}Home() {
        return ${targetApplicationId}Home;
    }

}
