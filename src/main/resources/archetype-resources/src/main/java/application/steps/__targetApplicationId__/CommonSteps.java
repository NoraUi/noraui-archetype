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
package ${package}.application.steps.${targetApplicationId};

import org.slf4j.Logger;

import ${package}.application.pages.${targetApplicationId}.CommonPage;

import com.github.noraui.application.page.Page;
import com.github.noraui.application.steps.Step;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.exception.TechnicalException;
import com.github.noraui.log.annotation.Loggable;
import com.github.noraui.utils.Context;
import com.google.inject.Inject;

import io.cucumber.java.en.Then;

@Loggable
public class CommonSteps extends Step {

    static Logger log;

    @Inject
    private CommonPage commonPage;

    /**
     * select2 is javascript librairy.
     *
     * @param id
     *            of select2.
     * @param value
     *            selected in drop-down list.
     * @param page
     *            on which is the drop-down list.
     * @throws FailureException
     *             if the scenario encounters a functional error.
     * @throws TechnicalException
     *             is thrown if you have a technical error (format, configuration, datas, ...) in NoraUi.
     */
    @Then("I update select2 list {string} with {string} on {string}")
    public void updateSelect2(String id, String value, String page) throws FailureException, TechnicalException {
        String realValue = Context.getValue(value) != null ? Context.getValue(value) : value;
        log.debug("updateSelect2 {} with {}", id, realValue);
        try {
            clickOn(commonPage.select2, id);
            clickOn(commonPage.select2Value, id, realValue);
        } catch (Exception e) {
            new Result.Failure<>(Page.getInstance(page).getApplication(), "Error when \"I update select2 '" + id + "' with '" + realValue + "' on '" + page + "': " + e.getMessage(), true,
                    Page.getInstance(page).getCallBack());
        }
    }

}
