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
package ${package}.application.pages.${targetApplicationId};

import static ${package}.utils.${robotName}Context.${targetApplicationId.toUpperCase()}_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;

import ${package}.utils.${robotName}Context;

import com.github.noraui.application.page.Page;
import com.github.noraui.browser.waits.Wait;
import com.github.noraui.log.annotation.Loggable;
import com.github.noraui.utils.Context;
import com.github.noraui.utils.Utilities;
import com.google.inject.Singleton;

@Loggable
@Singleton
public class ${targetApplicationName}Page extends Page {

    static Logger log;

    public final PageElement accountMenu = new PageElement("-accountMenu", "Account menu");
    public final PageElement signinMenu = new PageElement("-signinMenu", "Sign-in menu");
    public final PageElement signoutMenu = new PageElement("-signoutMenu", "Sign-out menu");
    public final PageElement signInMessage = new PageElement("-sign_in_message");

    public ${targetApplicationName}Page() {
        super();
        this.application = ${targetApplicationId.toUpperCase()}_KEY;
        this.pageKey = "${targetApplicationId.toUpperCase()}_PORTAL";
        this.callBack = Context.getCallBack(${robotName}Context.RESTART_WEB_DRIVER_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Wait.until(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(this.signInMessage, elements)));
            return true;
        } catch (Exception e) {
            log.error("${targetApplicationName}Page not loaded", e);
            return false;
        }
    }

}
