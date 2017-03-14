#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.pages.${targetApplication};

import static ${package}.utils.${robotName}Context.${targetApplication.toUpperCase()}_KEY;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.utils.${robotName}Context;

import noraui.application.page.Page;
import noraui.utils.Context;
import noraui.utils.Utilities;

public class LoginPage extends Page {

    private static Logger logger = Logger.getLogger(LoginPage.class.getName());

    public final PageElement login = new PageElement("-champs_login");
    public final PageElement password = new PageElement("-champs_password");
    public final PageElement submitButton = new PageElement("-bouton_connecter");

    public LoginPage() {
        super();
        this.application = ${targetApplication.toUpperCase()}_KEY;
        this.pageKey = "SLT_LOG";
        this.callBack = Context.getCallBack(${robotName}Context.GO_TO_${targetApplication.toUpperCase()}_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        if (!"phantom".equalsIgnoreCase(Context.getBrowser()) && !moreTests4CheckPageInNoPhantomCase()) {
            return false;
        }
        try {
            if ("".equals(Utilities.findElement(login).getText()) && "".equals(Utilities.findElement(password).getText())) {
                return true;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    private boolean moreTests4CheckPageInNoPhantomCase() {
        String title = "Bienvenue dans ${targetApplication.substring(0,1).toUpperCase()}${targetApplication.substring(1)}";
        try {
            Context.waitUntil(ExpectedConditions.titleIs(title));
            if (!Page.getDriver().getTitle().equals(title)) {
                return false;
            }
        } catch (Exception e) {
            logger.error(e);
            return false;
        }
        return true;
    }

}
