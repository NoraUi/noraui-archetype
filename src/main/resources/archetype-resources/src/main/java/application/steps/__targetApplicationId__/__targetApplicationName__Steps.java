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
import com.github.noraui.browser.Auth;
import com.github.noraui.browser.waits.Wait;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.log.annotation.Loggable;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Messages;
import com.github.noraui.utils.Utilities;
import com.google.inject.Inject;
import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}Page;
import ${package}.utils.${robotName}Messages;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Quand;

@Loggable
public class ${targetApplicationName}Steps extends Step {

    static Logger log;

    @Inject
    private ${targetApplicationName}Page ${targetApplicationId}Page;

    /**
     * Check ${targetApplicationName} portal page.
     * 
     * @param login
     *             login display on portal page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Alors("Le portail ${targetApplicationId.toUpperCase()} est affiché avec le login {string}")
    @Then("The ${targetApplicationId.toUpperCase()} portal is displayed with the login {string}")
    public void check${targetApplicationName}Page(String login) throws FailureException {
        try {
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signInMessage, login)));
            if (!${targetApplicationId}Page.checkPage(login)) {
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
    @Quand("Je me déconnecte de ${targetApplicationId.toUpperCase()}")
    @When("I log out of ${targetApplicationId.toUpperCase()}")
    public void logOutOf${targetApplicationName}() throws FailureException, TechnicalException {
        if (Auth.isConnected()) {
            getDriver().switchTo().defaultContent();
            try {
                clickOn(${targetApplicationId}Page.accountMenu);
                Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signoutMenu))).click();
            } catch (Exception e) {
                new Result.Failure<>(${targetApplicationId}Page.getApplication(), Messages.getMessage(Messages.FAIL_MESSAGE_LOGOUT), true, ${targetApplicationId}Page.getCallBack());
            }
        } else {
            log.warn(Messages.getMessage(${robotName}Messages.FAIL_MESSAGE_USER_WAS_ALREADY_LOGOUT, "${artifactId}"));
            Context.getCurrentScenario().write(Messages.getMessage(${robotName}Messages.FAIL_MESSAGE_USER_WAS_ALREADY_LOGOUT, "${artifactId}"));
        }
    }

}
