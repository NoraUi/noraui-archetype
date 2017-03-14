#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.steps.${targetApplication};

import org.apache.log4j.Logger;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.application.pages.${targetApplication}.PortalPage;
import ${package}.application.pages.${targetApplication}.LoginPage;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import noraui.application.page.Page;
import noraui.application.steps.Step;
import noraui.browser.Auth;
import noraui.exception.TechnicalException;
import noraui.utils.Context;
import noraui.utils.Utilities;

public class LogoutSteps extends Step {

    private static Logger logger = Logger.getLogger(LogoutSteps.class.getName());

    private PortalPage portalPage;
    private LoginPage loginPage;

    public LogoutSteps() throws TechnicalException {
        super();
        this.portalPage = (PortalPage) Page.getInstance(PortalPage.class);
        this.loginPage = (LoginPage) Page.getInstance(LoginPage.class);
    }

    /**
     * Logout of ${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}.
     */
    @When("^I log out of ${targetApplication.toUpperCase()}${symbol_dollar}")
    public void logOutOf${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}() {
        logger.info("Auth.isConnected()=" + Auth.isConnected());
        if (Auth.isConnected()) {
            Step.getDriver().switchTo().defaultContent();
            Utilities.findElement(portalPage.userMenu).click();
            Context.waitUntil(ExpectedConditions.presenceOfElementLocated(noraui.utils.Utilities.getLocator(portalPage.logoutMenuItem))).click();
            if ("ie".equalsIgnoreCase(Context.getBrowser())) {
                try {
                    Context.waitUntil(ExpectedConditions.alertIsPresent());
                    Step.getDriver().switchTo().alert().dismiss();
                    Step.getDriver().switchTo().defaultContent();
                } catch (NoAlertPresentException e) {
                    logger.error(e);
                }
            }
        }
    }

    /**
     *
     */
    @Then("^The ${targetApplication.toUpperCase()} logout page is displayed${symbol_dollar}")
    public void check${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}LoginPage() {
        loginPage.checkPage();
    }

}
