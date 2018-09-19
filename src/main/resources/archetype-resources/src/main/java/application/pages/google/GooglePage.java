#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * 
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package ${package}.application.pages.google;

import static ${package}.utils.${robotName}Context.GOOGLE_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.utils.${robotName}Context;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;

public class GooglePage extends Page {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(GooglePage.class);

    private static final String TITLE_PAGE = "Google";

    public GooglePage() {
        super();
        this.application = GOOGLE_KEY;
        this.pageKey = "GOOGLE_HOME";
        this.callBack = Context.getCallBack(${robotName}Context.CLOSE_WINDOW_AND_SWITCH_TO_GOOGLE_HOME);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean checkPage(Object... elements) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!TITLE_PAGE.equals(getDriver().getTitle())) {
                logger.error("HTML title is not good");
                return false;
            }
            return true;
        } catch (Exception e) {
            logger.error("HTML title Exception", e);
            return false;
        }
    }

}
