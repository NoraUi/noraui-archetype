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

import static com.github.noraui.browser.steps.BrowserSteps.CLOSE_WINDOW_AND_SWITCH_TO;
import static com.github.noraui.browser.steps.BrowserSteps.CLOSE_ALL_WINDOWS_AND_SWITCH_TO;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.Application;
import com.github.noraui.application.page.Page;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;

public class ${robotName}Context extends Context {

    /**
     * Specific LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${robotName}Context.class);

    // applications
    public static final String ${targetApplicationId.toUpperCase()}_KEY = "${targetApplicationId}";
    public static final String ${targetApplicationId.toUpperCase()}_HOME = "${targetApplicationId.toUpperCase()}_HOME";
    private String ${targetApplicationId}Home; // ${targetApplicationId.toUpperCase()} home url
    public static final String GOOGLE_KEY = "google";
    public static final String GOOGLE_HOME = "GOOGLE_HOME";
    private String googleHome; // GOOGLE home url
    public static final String LOGOGAME_KEY = "logogame";
    public static final String LOGOGAME_HOME = "LOGOGAME_HOME";
    private String logogameHome; // LOGOGAME home url

    // targets
    public static final String GO_TO_${targetApplicationId.toUpperCase()}_HOME = "GO_TO_${targetApplicationId.toUpperCase()}_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME";
    public static final String GO_TO_GOOGLE_HOME = "GO_TO_GOOGLE_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME";
    public static final String GO_TO_LOGOGAME_HOME = "GO_TO_LOGOGAME_HOME";
    public static final String CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME = "CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME";
    public static final String CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME = "CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME";

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
    public synchronized void initializeRobot(Class<?> clazz) throws TechnicalException {
        super.initializeRobot(clazz);
        LOGGER.info("${robotName}Context > initializeRobot()");
        
        // This line is here as an example to show how to do with internationalization using messages bundles.
        LOGGER.info(Messages.format(Messages.getMessage("HELLO", "${artifactId}"), "${artifactId}"));

        // Urls configuration
        ${targetApplicationId}Home = getProperty(${targetApplicationId.toUpperCase()}_KEY, applicationProperties);
        googleHome = getProperty(GOOGLE_KEY, applicationProperties);
        logogameHome = getProperty(LOGOGAME_KEY, applicationProperties);

        // Selectors configuration
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, ${targetApplicationId.toUpperCase()}_KEY);
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, GOOGLE_KEY);
        initApplicationDom(clazz.getClassLoader(), selectorsVersion, LOGOGAME_KEY);
 
        // Exception Callbacks
        exceptionCallbacks.put(GO_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, ${targetApplicationId.toUpperCase()}_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_WINDOW_AND_SWITCH_TO, ${targetApplicationId.toUpperCase()}_KEY, ${targetApplicationId.toUpperCase()}_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_ALL_WINDOWS_AND_SWITCH_TO, ${targetApplicationId.toUpperCase()}_KEY);
        exceptionCallbacks.put(GO_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, GOOGLE_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_WINDOW_AND_SWITCH_TO, GOOGLE_KEY, GOOGLE_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_GOOGLE_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_ALL_WINDOWS_AND_SWITCH_TO, GOOGLE_KEY);
        exceptionCallbacks.put(GO_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, GO_TO_URL_METHOD_NAME, LOGOGAME_HOME);
        exceptionCallbacks.put(CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_WINDOW_AND_SWITCH_TO, LOGOGAME_KEY, LOGOGAME_HOME);
        exceptionCallbacks.put(CLOSE_ALL_WINDOWS_AND_SWITCH_TO_LOGOGAME_HOME, STEPS_BROWSER_STEPS_CLASS_QUALIFIED_NAME, CLOSE_ALL_WINDOWS_AND_SWITCH_TO, LOGOGAME_KEY);

        // applications mapping
        applications.put(${targetApplicationId.toUpperCase()}_KEY, new Application(${targetApplicationId.toUpperCase()}_HOME, ${targetApplicationId}Home));
        applications.put(GOOGLE_KEY, new Application(GOOGLE_HOME, googleHome));
        applications.put(LOGOGAME_KEY, new Application(LOGOGAME_HOME, logogameHome));

        Page.setPageMainPackage("${package}.application.pages.");
#if ( $share != "false" )

        statistics.share(statisticsProcessor(clazz.getClassLoader(), "${package}.application.steps"));
#end        
    }
    
    /**
     * Get context singleton.
     *
     * @return context instance
     */
    public static Context getInstance() {
        if (!(instance instanceof ${robotName}Context)) {
            instance = new ${robotName}Context();
        }
        return instance;
    }

    // home getters
    public String get${targetApplicationId.substring(0,1).toUpperCase()}${targetApplicationId.substring(1)}Home() {
        return ${targetApplicationId}Home;
    }
    public String getGoogleHome() {
        return googleHome;
    }
    public String getLogogameHome() {
        return logogameHome;
    }

}
