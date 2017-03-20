#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.pages.${targetApplicationId};

import static ${package}.utils.${robotName}Context.${targetApplicationId.toUpperCase()}_KEY;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.utils.${robotName}Context;

import noraui.application.page.Page;
import noraui.browser.Auth;
import noraui.exception.Callbacks;
import noraui.exception.FailureException;
import noraui.utils.Context;
import noraui.utils.Utilities;

public class ${targetApplicationName}Page extends Page {

    private static Logger logger = Logger.getLogger(${targetApplicationName}Page.class.getName());

    public final PageElement accountMenu = new PageElement("-accountMenu", "Account menu");
    public final PageElement signinMenu = new PageElement("-signinMenu", "Sign-in menu");
    public final PageElement signoutMenu = new PageElement("-signoutMenu", "Sign-out menu");
    public final PageElement login = new PageElement("-login-field", "Login");
    public final PageElement password = new PageElement("-password-field", "Password");
    public final PageElement signInButton = new PageElement("-sign-in-button", "Sign-in button");
    public final PageElement signInMessage = new PageElement("-sign-in-message");

    private static final String TITLE_PAGE = "${targetApplicationId}";

    public ${targetApplicationName}Page() {
        super();
        this.application = ${targetApplicationId.toUpperCase()}_KEY;
        this.pageKey = "APP_HOM";
        this.callBack = Context.getCallBack(${robotName}Context.CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(Page.getDriver().getTitle())) {
                logger.error("HTML title is not good");
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
    }
    
    /**
     * isDisplayed returns true if ${targetApplicationId.toUpperCase()} portal page is displayed.
     *
     * @return boolean
     */
    public boolean isDisplayed() {
        return isDisplayed(TITLE_PAGE);
    }
    
    /**
     * isDisplayed returns true if the required ${targetApplicationId.toUpperCase()} portal page is displayed.
     *
     * @param titlePage
     *            The page title to check
     * @return boolean
     */
    public boolean isDisplayed(String titlePage) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!titlePage.equals(Page.getDriver().getTitle())) {
                return false;
            }
        } catch (Exception e) {
            logger.error("Exception in isDisplayed: " + e);
            return false;
        }
        return true;
    }
    
}