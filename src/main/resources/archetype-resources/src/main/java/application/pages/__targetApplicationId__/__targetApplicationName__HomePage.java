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
public class ${targetApplicationName}HomePage extends Page {

    static Logger log;

    public final PageElement login = new PageElement("-login_field", "Login");
    public final PageElement password = new PageElement("-password_field", "Password");
    public final PageElement signInButton = new PageElement("-sign_in_button", "Sign-in button");

    public final PageElement signInError = new PageElement("-sign_in_error", "Sign-in error");
    
    private static final String TITLE_PAGE = "${targetApplicationTitle}";

    public ${targetApplicationName}HomePage() {
        super();
        this.application = ${targetApplicationId.toUpperCase()}_KEY;
        this.pageKey = "${targetApplicationId.toUpperCase()}_HOME";
        this.callBack = Context.getCallBack(${robotName}Context.CLOSE_WINDOW_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Wait.until(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!getDriver().getTitle().contains(TITLE_PAGE)) {
                log.error("HTML title is not good");
                return false;
            }
            // Wait.untilAnd(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(this.login)))
            //   .wait(() -> ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(this.password)))
            //   .wait(() -> ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(this.signInButton)));
            return true;
        } catch (Exception e) {
            log.error("${targetApplicationName}HomePage not loaded", e);
            return false;
        }
    }

}
