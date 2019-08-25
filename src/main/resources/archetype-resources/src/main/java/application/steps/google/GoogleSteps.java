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
package ${package}.application.steps.google;

import com.github.noraui.application.steps.Step;
import com.github.noraui.exception.FailureException;
import com.github.noraui.exception.Result;
import com.github.noraui.utils.Messages;
import com.google.inject.Inject;
import ${package}.application.pages.google.GooglePage;

import io.cucumber.java.en.Then;

public class GoogleSteps extends Step {

    @Inject
    private GooglePage googlePage;

    /**
     * Check Login page.
     *
     * @throws FailureException
     *             if the scenario encounters a functional error.
     */
    @Then("The GOOGLE home page is displayed")
    public void checkGoogleHomePage() throws FailureException {
        if (!googlePage.checkPage()) {
            new Result.Failure<>(googlePage.getApplication(),
                    Messages.getMessage(Messages.FAIL_MESSAGE_HOME_PAGE_NOT_FOUND), true, googlePage.getCallBack());
        }
    }

}
