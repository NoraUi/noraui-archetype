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
package ${package}.cucumber.module;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.inject.Binder;
import com.google.inject.Module;
import ${package}.application.business.service.ProhibitedBrandsService;
import ${package}.application.business.service.impl.ProhibitedBrandsServiceImpl;

public class ${robotName}Module implements Module {

    private static final Logger LOGGER = LoggerFactory.getLogger(${robotName}Module.class);

    /**
     * {@inheritDoc}
     */
    @Override
    public void configure(Binder binder) {
        LOGGER.debug("${robotName} interceptors binding");
        binder.bind(ProhibitedBrandsService.class).to(ProhibitedBrandsServiceImpl.class).asEagerSingleton();
    }
    
}
