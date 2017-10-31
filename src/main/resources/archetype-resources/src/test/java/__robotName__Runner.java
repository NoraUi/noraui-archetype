#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package};

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;

import ${package}.utils.${robotName}Context;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import noraui.exception.TechnicalException;
import noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = { "noraui.application.steps", "noraui.browser.steps", "${package}.application.steps" }, plugin = { "html:target/reports/html", "json:target/reports/json/report.json", "junit:target/reports/junit/report.xml" },
features = { "src/test/resources" })
public class ${robotName}Runner {

    /**
     * BeforeClass Read constants file.
     * 
     * @throws TechnicalException is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @BeforeClass
    public static void setUpClass() throws TechnicalException {
        ${robotName}Context.getInstance().initializeEnv("${robotName}.properties");
        ${robotName}Context.getInstance().initializeRobot(${robotName}Runner.class);
    }

    /**
     * AfterClass clear Context.
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}
