#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.steps.${targetApplication};

import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.application.pages.${targetApplication}.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import noraui.application.page.Page;
import noraui.application.steps.Step;
import noraui.browser.Auth;
import noraui.exception.FailureException;
import noraui.exception.Result;
import noraui.exception.TechnicalException;
import noraui.utils.Context;
import noraui.utils.Messages;
import noraui.utils.Utilities;

public class LoginSteps extends Step {

    private LoginPage ${targetApplication}LoginPage;

    public LoginSteps() throws TechnicalException {
        super();
        this.${targetApplication}LoginPage = (LoginPage) Page.getInstance(LoginPage.class);
    }

    /**
     *
     */
    @Then("The ${targetApplication.toUpperCase()} login page is displayed")
    public void check${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}LoginPage() {
        this.${targetApplication}LoginPage.checkPage();
    }

    /**
     * Log in to ${targetApplication.toUpperCase()} without Rapid (login and password in Gherkin scenario)
     *
     * @param login
     *            Login to use
     * @param password
     *            Password to use
     * @throws FailureException
     *             if the scenario encounters a functional error
     */
    @When("I log in to ${targetApplication.toUpperCase()} as '(.*)' '(.*)'")
    public void logInTo${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}(String login, String password) throws FailureException {
        try {
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplication}LoginPage.submitButton)));
            Utilities.findElement(${targetApplication}LoginPage.login).sendKeys(login);
            Utilities.findElement(${targetApplication}LoginPage.password).sendKeys(password);
            Utilities.findElement(${targetApplication}LoginPage.submitButton).click();
        } catch (Exception e) {
            new Result.Failure<>(e, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplication}LoginPage.getCallBack());
        }
        Auth.setConnected(true);
    }

    /**
     * Log in to ${targetApplication.toUpperCase()} with Rapid (login and password in job parameters)
     *
     * @throws FailureException
     *             if the scenario encounters a functional error
     * @
     * With FAIL_MESSAGE_UNKNOWN_CREDENTIALS message (Screenshot no exception)
     */
    private void logInTo${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}WithRapid() throws FailureException {
        String login = Auth.getLogin();
        String password = Auth.getPassword();
        if (!"".equals(login) && !"".equals(password)) {
            logInTo${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}(login, password);
        }
    }
}
