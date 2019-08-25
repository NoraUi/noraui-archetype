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
package ${package};

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import ${package}.utils.${robotName}Context;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true,
                       glue = { "com.github.noraui.cucumber.config", "com.github.noraui.application.steps", "com.github.noraui.browser.steps", "${package}.application.steps" },
					 plugin = { "summary", "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
                   features = { "src/test/resources" })
public class ${robotName}RunnerApi {

    /**
     * BeforeClass Read constants file.
     * 
     * @throws TechnicalException is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        ${robotName}Context.getInstance().initializeEnv("${robotName}.properties");
        ${robotName}Context.getInstance().initializeRobot(${robotName}RunnerApi.class);
	}

    /**
     * AfterClass clear Context
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}
