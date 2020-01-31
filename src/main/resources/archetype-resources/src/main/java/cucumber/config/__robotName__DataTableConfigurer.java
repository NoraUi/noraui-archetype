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
package ${package}.cucumber.config;

import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;

import com.github.noraui.cucumber.config.DataTableConfigurer;
import com.github.noraui.log.annotation.Loggable;
import com.id2s.gherkin.Sample;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.datatable.DataTableType;
import io.cucumber.datatable.TableEntryTransformer;

@Loggable
public class ${robotName}DataTableConfigurer extends DataTableConfigurer {

    static Logger log;

    @Override
    public Locale locale() {
        return Locale.ENGLISH;
    }

    @Override
    public void configureTypeRegistry(TypeRegistry registry) {
        registry.defineDataTableType(new DataTableType(Sample.class, new TableEntryTransformer<Sample>() {
            @Override
            public Sample transform(Map<String, String> entry) {
                log.debug("configureTypeRegistry Sample type:{}", entry.get("type"));
                log.debug("configureTypeRegistry Sample id:{}", entry.get("id"));
                log.debug("configureTypeRegistry Sample value:{}", entry.get("value"));
                return new Sample(entry.get("type"), entry.get("id"), Integer.parseInt(entry.get("value")));
            }
        }));
    }

}
