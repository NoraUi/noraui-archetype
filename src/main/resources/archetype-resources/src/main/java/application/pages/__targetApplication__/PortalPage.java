#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.pages.${targetApplication};

import static ${package}.utils.${robotName}Context.${targetApplication.toUpperCase()}_KEY;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.utils.${robotName}Context;

import noraui.application.page.Page;
import noraui.browser.Auth;
import noraui.utils.Context;
import noraui.utils.Utilities;

public class PortalPage extends Page {

    private static Logger logger = Logger.getLogger(PortalPage.class.getName());

    public final PageElement userMenu = new PageElement("-userMenu", "Menu utilisateur");
    public final PageElement logoutMenuItem = new PageElement("-logOut");

    public PortalPage() {
        super();
        this.application = ${targetApplication.toUpperCase()}_KEY;
        this.pageKey = "SLT_CON_POR";
        this.callBack = Context.getCallBack(${robotName}Context.GO_TO_${targetApplication.toUpperCase()}_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            if (!"".equals(Utilities.findElement(userMenu).getText())) {
                Auth.setConnected(true);
                return true;
            }
        } catch (Exception e) {
            logger.error(e);
        }
        return false;
    }

    /**
     * isDisplayed returns true if the required SALTO portal page is displayed.
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
