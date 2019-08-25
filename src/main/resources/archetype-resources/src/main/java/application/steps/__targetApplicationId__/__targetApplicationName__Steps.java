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
package ${package}.application.steps.${targetApplicationId};

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.noraui.application.steps.Step;
import com.github.noraui.browser.Auth;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;
import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}Page;
import ${package}.utils.${robotName}Messages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ${targetApplicationName}Steps extends Step {
    
    /**
     * Specific LOGGER
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(${targetApplicationName}Steps.class);

    @Inject
    private ${targetApplicationName}Page ${targetApplicationId}Page;
   
    /**
     * Check Login page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The ${targetApplicationId.toUpperCase()} home page is displayed")
    public void check${targetApplicationName}LoginPage() throws FailureException {
        if (!${targetApplicationId}Page.checkPage()) {
            new Result.Failure<>(${targetApplicationId}Page.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}Page.getCallBack());
        }
    }
   
    /**
     * Log in to ${targetApplicationId.toUpperCase()} without ${robotName} (login and password in Gherkin scenario).
     *
     * @param login
     *            Login to use.
     * @param password
     *            Password to use.
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @When("I log in to ${targetApplicationId.toUpperCase()} as {string} {string}")
    public void logInTo${targetApplicationName}(String login, String password) throws FailureException {
        LOGGER.debug("logIn to ${targetApplicationName} with login [{}] and password [{}].");
        try {
            Utilities.findElement(${targetApplicationId}Page.accountMenu).click();
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signinMenu))).click();
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signInButton)));
            Utilities.findElement(${targetApplicationId}Page.login).sendKeys(login);
            Utilities.findElement(${targetApplicationId}Page.password).sendKeys(getTextOrKey(password));
            Utilities.findElement(${targetApplicationId}Page.signInButton).click();
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}Page.getCallBack());
        }
   }
   
    /**
     * Check ${targetApplicationName} portal page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The ${targetApplicationId.toUpperCase()} portal is displayed")
    public void check${targetApplicationName}Page() throws FailureException {
        try {
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signInMessage)));
            if (!${targetApplicationId}Page.isDisplayed()) {
                logInTo${targetApplicationName}With${robotName}();
            }
            if (!${targetApplicationId}Page.checkPage()) {
                new Result.Failure<>(${targetApplicationId}Page.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}Page.getCallBack());
            }
        } catch (Exception e) {
            new Result.Failure<>(${targetApplicationId}Page.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}Page.getCallBack());
        }    
        Auth.setConnected(true);
    }
   
    /**
     * Logout of ${targetApplicationName}.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     * @throws TechnicalException
     *             is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @When("I log out of ${targetApplicationId.toUpperCase()}")
    public void logOutOf${targetApplicationName}() throws FailureException, TechnicalException {
        if (Auth.isConnected()) {
            getDriver().switchTo().defaultContent();
            clickOn(${targetApplicationId}Page.accountMenu);
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signoutMenu))).click();
        } else {
            LOGGER.warn(Messages.getMessage(${robotName}Messages.USER_WAS_ALREADY_LOGOUT, "robot"));
            Context.getCurrentScenario().write(Messages.getMessage(${robotName}Messages.USER_WAS_ALREADY_LOGOUT, "robot"));	   
	    }
    }
   
    /**
     * Check Logout page.
     */
    @Then("The ${targetApplicationId.toUpperCase()} logout page is displayed")
    public void check${targetApplicationName}LogoutPage() {
        ${targetApplicationId}Page.checkPage();
    }
  
    /**
     * Log in to ${targetApplicationId.toUpperCase()} with ${robotName} (login and password in job parameters).
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    private void logInTo${targetApplicationName}With${robotName}() throws FailureException {
        String login = Auth.getLogin();
        String password = Auth.getPassword();
        if (!"".equals(login) && !"".equals(password)) {
            logInTo${targetApplicationName}(login, password);
        }
    }

}
