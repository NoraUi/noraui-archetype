#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
/**
 * ${robotName} generated free by NoraUi Organization https://github.com/NoraUi
 * ${robotName} is licensed under the license BSD.
 * 
 * CAUTION: ${robotName} use NoraUi library. This project is licensed under the license GNU AFFERO GENERAL PUBLIC LICENSE
 */
package ${package}.application.pages.logogame;

import static ${package}.utils.${robotName}Context.LOGOGAME_KEY;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ${package}.utils.${robotName}Context;

import com.github.noraui.application.page.Page;
import com.github.noraui.utils.Context;


public class LogogamePage extends Page {

    /**
     * Specific logger
     */
    private static final Logger logger = LoggerFactory.getLogger(LogogamePage.class);

    public final PageElement bigTitle = new PageElement("-big-title", "Logo Game");
    public final PageElement amazonElement = new PageElement("-amazonElement", "Input Text Amazon");
    public final PageElement brandElement = new PageElement("-brandElement");
    public final PageElement validateButton = new PageElement("-validateButton", "Validate Button");
    public final PageElement addButton = new PageElement("-addButton", "Add Button");
    public final PageElement brandList = new PageElement("-brandList", "Brand Drop Down");
    public final PageElement scoreMessage = new PageElement("-scoreMessage", "Score message");
    public final PageElement alertMessage = new PageElement("-alertMessage", "Alert message");

    private static final String TITLE_PAGE = "Logo Game";

    public LogogamePage() {
        super();
        this.application = LOGOGAME_KEY;
        this.pageKey = "LOGOGAME_HOME";
        this.callBack = Context.getCallBack(${robotName}Context.CLOSE_WINDOW_AND_SWITCH_TO_LOGOGAME_HOME);
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

    /**
     * isDisplayed returns true if LOGOGAME portal page is displayed.
     *
     * @return boolean
     */
    public boolean isDisplayed() {
        return isDisplayed(TITLE_PAGE);
    }

    /**
     * isDisplayed returns true if the required LOGOGAME portal page is displayed.
     *
     * @param titlePage
     *            The page title to check
     * @return boolean
     */
    public boolean isDisplayed(String titlePage) {
        try {
            Context.waitUntil(ExpectedConditions.not(ExpectedConditions.titleIs("")));
            if (!titlePage.equals(getDriver().getTitle())) {
                return false;
            }
        } catch (Exception e) {
            logger.error("Exception in isDisplayed", e);
            return false;
        }
        return true;
    }

}
