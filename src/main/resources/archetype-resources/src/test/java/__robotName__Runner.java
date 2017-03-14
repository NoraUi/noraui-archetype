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
import noraui.utils.Context;

@RunWith(Cucumber.class)
@CucumberOptions(monochrome = true, glue = { "noraui.application.steps", "${package}.application.steps" },
        plugin = { "pretty", "html:target/reports/html", "json:target/reports/json/results.json" }, features = { "src/test/resources" })
public class ${robotName}Runner {

    /**
     * BeforeClass Read constants file
     */
    @BeforeClass
    public static void setUpClass() {
        ${robotName}Context.getInstance().initializeEnv(${robotName}Runner.class.getClassLoader(), "${targetApplication}.properties");
    }

    /**
     * AfterClass clear Context
     */
    @AfterClass
    public static void tearDownClass() {
        Context.clear();
    }

}
