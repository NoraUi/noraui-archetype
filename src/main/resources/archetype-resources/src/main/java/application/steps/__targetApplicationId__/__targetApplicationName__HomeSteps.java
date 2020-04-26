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

import com.github.noraui.application.steps.Step;
import com.github.noraui.browser.waits.Wait;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.log.annotation.Loggable;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;

import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}Page;
import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}HomePage;
import ${package}.utils.${robotName}Messages;

import io.cucumber.java.en.Then;
import io.cucumber.java.fr.Alors;

@Loggable
public class ${targetApplicationName}HomeSteps extends Step {

    static Logger log;

    @Inject
    private ${targetApplicationName}HomePage ${targetApplicationId}HomePage;
    
    @Inject
    private ${targetApplicationName}Page ${targetApplicationId}Page;

    /**
     * Check home page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Alors("La page d'accueil ${targetApplicationId.toUpperCase()} est affichée")
    @Then("The ${targetApplicationId.toUpperCase()} home page is displayed")
    public void check${targetApplicationName}HomePage() throws FailureException {
        if (!${targetApplicationId}HomePage.checkPage()) {
            new Result.Failure<>(${targetApplicationId}HomePage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}HomePage.getCallBack());
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
    @Alors("Je me connecte sur ${targetApplicationId.toUpperCase()} avec {string} {string}")
    @Then("I log in to ${targetApplicationId.toUpperCase()} as {string} {string}")
    public void logInTo${targetApplicationName}(String login, String password) throws FailureException {
        log.debug("logIn to ${targetApplicationName} with login [{}] and password [{}].", login, password);
        try {
            Utilities.findElement(${targetApplicationId}Page.accountMenu).click();
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signinMenu))).click();
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}Page.getCallBack());
        }
        try {
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}HomePage.login)));
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}HomePage.password)));
            Utilities.findElement(${targetApplicationId}HomePage.login).sendKeys(login);
            Utilities.findElement(${targetApplicationId}HomePage.password).sendKeys(getTextOrKey(password));
            Wait.until(ExpectedConditions.elementToBeClickable(Utilities.getLocator(${targetApplicationId}HomePage.signInButton)));
            Utilities.findElement(${targetApplicationId}HomePage.signInButton).click();
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.getMessage(Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS), true, ${targetApplicationId}HomePage.getCallBack());
        }
    }

    /**
     * Check Logout page.
     * 
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Alors("La page de déconnexion de ${targetApplicationId.toUpperCase()} est affichée")
    @Then("The ${targetApplicationId.toUpperCase()} logout page is displayed")
    public void check${targetApplicationName}LogoutPage() throws FailureException {
        if (!${targetApplicationId}HomePage.checkPage()) {
            new Result.Failure<>(${targetApplicationId}HomePage.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_LOGOUT), true, ${targetApplicationId}HomePage.getCallBack());
        }
    }
    
    /**
     * Check Log in Error to ${targetApplicationId.toUpperCase()}.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Alors("Une erreur de connexion est affichée")
    @Then("A login error is displayed")
    public void checkEpideLoginError() throws FailureException {
        log.debug("Check login error page.");
        try {
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}HomePage.signInError)));
            if (Utilities.findElement(${targetApplicationId}HomePage.signInError) == null) {
                new Result.Failure<>(${targetApplicationId}HomePage.getApplication(), Messages.getMessage(${robotName}Messages.FAIL_MESSAGE_USER_SHOULD_NOT_LOGIN, "${artifactId}"), true,
                        ${targetApplicationId}HomePage.getCallBack());
            }
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.getMessage(${robotName}Messages.FAIL_MESSAGE_USER_SHOULD_NOT_LOGIN, "${artifactId}"), true, ${targetApplicationId}HomePage.getCallBack());
        }
    }

}
