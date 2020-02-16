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
package ${package}.application.business.service.impl;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;

import com.github.noraui.cucumber.injector.NoraUiInjector;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.log.NoraUiLoggingInjector;
import com.github.noraui.log.annotation.Loggable;
import com.google.inject.Inject;
import ${package}.application.business.service.ProhibitedBrandsService;
import ${package}.cucumber.injector.${robotName}InjectorSource;

@Loggable
public class ProhibitedBrandsServiceImplUT {

    static Logger log;

    @Inject
    private ProhibitedBrandsService prohibitedBrandsService;

    @Before
    public void setUp() throws TechnicalException {
        NoraUiInjector.resetInjector();
        new ${robotName}InjectorSource().getInjector().injectMembers(this);
        NoraUiLoggingInjector.addInjector(this.getClass().getPackage().getName());
    }

    @After
    public void tearDown() {
        NoraUiInjector.resetInjector();
    }

    @Test
    public void testGetTabaco() {
        List<String> tabacos = prohibitedBrandsService.getTabaco();
        for (String tabaco : tabacos) {
            log.info(tabaco);
        }
    }

}
