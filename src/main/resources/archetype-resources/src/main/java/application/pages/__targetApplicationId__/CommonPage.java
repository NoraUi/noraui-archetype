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

import org.slf4j.Logger;

import ${package}.utils.${robotName}Context;

import com.github.noraui.application.page.Page;
import com.github.noraui.log.annotation.Loggable;
import com.github.noraui.utils.Context;
import com.google.inject.Singleton;

@Loggable
@Singleton
public class CommonPage extends Page {

    static Logger log;

    /**
     * select2 is javascript librairy.
     */
    public final PageElement select2 = new PageElement("-select2");
    public final PageElement select2Value = new PageElement("-select2_value");

    public CommonPage() {
        super();
        this.application = ${targetApplicationId.toUpperCase()}_KEY;
        this.pageKey = "${targetApplicationId.toUpperCase()}_COMMON";
        this.callBack = Context.getCallBack(${robotName}Context.RESTART_WEB_DRIVER_AND_SWITCH_TO_${targetApplicationId.toUpperCase()}_HOME);
    }

    @Override
    public boolean checkPage(Object... elements) {
        return true;
    }

}
