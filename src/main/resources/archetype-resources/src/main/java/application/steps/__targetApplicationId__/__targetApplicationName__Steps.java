#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.steps.${targetApplicationId};

import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}Page;

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

public class ${targetApplicationName}Steps extends Step {

    public static final String ${targetApplicationId.toUpperCase()} = "${targetApplicationId.toUpperCase()}";

    private ${targetApplicationName}Page ${targetApplicationId}Page;

    public ${targetApplicationName}Steps() throws TechnicalException {
        super();
        this.${targetApplicationId}Page = (${targetApplicationName}Page) Page.getInstance(${targetApplicationName}Page.class);
    }
    
   /**
    * Check Login page.
    *
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @Then("The ${targetApplicationId.toUpperCase()} home page is displayed")
   public void check${targetApplicationName}LoginPage() throws FailureException {
       if (!${targetApplicationId}Page.checkPage()) {
           new Result.Failure<>(${targetApplicationId.toUpperCase()}, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplicationId}Page.getCallBack());
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
   @When("I log in to ${targetApplicationId.toUpperCase()} as '(.*)' '(.*)'")
   public void logInTo${targetApplicationName}(String login, String password) throws FailureException {
       try {
           Utilities.findElement(${targetApplicationId}Page.accountMenu).click();
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(noraui.utils.Utilities.getLocator(${targetApplicationId}Page.signinMenu))).click();
           
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.signInButton)));
           Utilities.findElement(${targetApplicationId}Page.login).sendKeys(login);
           Utilities.findElement(${targetApplicationId}Page.password).sendKeys(password);
           Utilities.findElement(${targetApplicationId}Page.signInButton).click();
       } catch (Exception e) {
           new Result.Failure<>(e, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplicationId}Page.getCallBack());
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
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(noraui.utils.Utilities.getLocator(${targetApplicationId}Page.signInMessage)));
           if (!${targetApplicationId}Page.isDisplayed()) {
               logInTo${targetApplicationName}With${robotName}();
           }
           if (!${targetApplicationId}Page.checkPage()) {
               new Result.Failure<>(${targetApplicationId.toUpperCase()}, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplicationId}Page.getCallBack());
           }
       } catch (Exception e) {
           new Result.Failure<>(${targetApplicationId.toUpperCase()}, Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplicationId}Page.getCallBack());
       }    
       Auth.setConnected(true);
   }
   
   /**
    * Logout of ${targetApplicationName}.
    * @throws FailureException
    *             if the scenario encounters a functional error.
    */
   @When("I log out of ${targetApplicationId.toUpperCase()}")
   public void logOutOf${targetApplicationName}() throws FailureException {
       if (Auth.isConnected()) {
           Step.getDriver().switchTo().defaultContent();
           Utilities.findElement(${targetApplicationId}Page.accountMenu).click();
           Context.waitUntil(ExpectedConditions.presenceOfElementLocated(noraui.utils.Utilities.getLocator(${targetApplicationId}Page.signoutMenu))).click();
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
