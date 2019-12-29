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
package ${package}.cucumber.injector;

import java.util.stream.Stream;

import org.slf4j.Logger;

import com.github.noraui.cucumber.injector.NoraUiInjector;
import com.github.noraui.cucumber.injector.NoraUiInjectorSource;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.log.annotation.Loggable;
import com.google.inject.Guice;
import com.google.inject.Injector;
import ${package}.cucumber.module.${robotName}Module;

@Loggable
public class ${robotName}InjectorSource extends NoraUiInjectorSource {

    static Logger log;

    /**
     * {@inheritDoc}
     */
    @Override
    public Injector getInjector() {
        Injector injector = Guice.createInjector(super.stage, () -> Stream.concat(super.noraUiModules.stream(), Stream.of(new ${robotName}Module())).iterator());
        try {
            NoraUiInjector.createInjector(injector);
        } catch (TechnicalException e) {
            log.error("${robotName}InjectorSource.getInjector()", e);
        }
        return injector;
    }
    
}
