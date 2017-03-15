#set( $symbol_pound = '#' )
#set( $symbol_dollar = '$' )
#set( $symbol_escape = '\' )
package ${package}.application.steps.${targetApplicationId};

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import ${package}.application.model.${targetApplicationId}.Logo;
import ${package}.application.model.${targetApplicationId}.Logos;
import ${package}.application.pages.${targetApplicationId}.${targetApplicationName}Page;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.fr.Alors;
import cucumber.api.java.fr.Et;
import cucumber.metrics.annotation.time.Time;
import cucumber.metrics.annotation.time.TimeValue;
import noraui.application.page.Page;
import noraui.application.steps.Step;
import noraui.exception.FailureException;
import noraui.exception.Result;
import noraui.exception.TechnicalException;
import noraui.utils.Context;
import noraui.utils.Messages;
import noraui.utils.Utilities;

public class ${targetApplicationName}Steps extends Step {

    private static Logger logger = Logger.getLogger(${targetApplicationName}Steps.class.getName());

    private ${targetApplicationName}Page ${targetApplicationId}Page;

    public ${targetApplicationName}Steps() throws TechnicalException {
        super();
        this.${targetApplicationId}Page = (${targetApplicationName}Page) Page.getInstance(${targetApplicationName}Page.class);
    }

    @Alors("Le portail ${targetApplicationId.toUpperCase()} est affiché")
    @Then("The ${targetApplicationId.toUpperCase()} portal is displayed")
    public void checkDemoPortalPage() throws FailureException {
        if (!${targetApplicationId}Page.checkPage()) {
            new Result.Failure<>("${targetApplicationId.toUpperCase()}", Messages.FAIL_MESSAGE_UNKNOWN_CREDENTIALS, true, ${targetApplicationId}Page.getCallBack());
        }
    }

    @Time
    @Alors("Je joue avec 'amazon'")
    @Then("I play with 'amazon'")
    public void playAmazon() throws FailureException {
        try {
            updateText(${targetApplicationId}Page.amazonElement, "amazon");
        } catch (TechnicalException e) {
            new Result.Failure<>("${targetApplicationId.toUpperCase()}", TechnicalException.TECHNICAL_ERROR_MESSAGE + e.getMessage(), true, ${targetApplicationId}Page.getCallBack());
        }
    }

    @Time()
    @Alors("J'ajoute '(.*)' marque\\(s\\) aléatoire\\(s\\)")
    @Then("I add '(.*)' random brand")
    public void addRandomBrand(@TimeValue("nb") int nb) throws FailureException {
        for (int i = 0; i < nb; i++) {
            try {
                clickOn(${targetApplicationId}Page.addButton);
            } catch (TechnicalException e) {
                new Result.Failure<>("${targetApplicationId.toUpperCase()}", TechnicalException.TECHNICAL_ERROR_MESSAGE + e.getMessage(), true, ${targetApplicationId}Page.getCallBack());
            }
        }
    }

    @Et("Je vérifie le message d'alerte")
    @And("I check alert message")
    public void checkAlertMessage() throws TechnicalException, FailureException {
        checkText(${targetApplicationId}Page.alertMessage, "There are no more logos available");
    }

    @Alors("Je joue avec mon fichier d'entrée '(.*)'")
    @Then("I play with my input file '(.*)'")
    public void playWithMyInputFile(String jsonLogos) throws TechnicalException {
        Logos logos = new Logos();
        logos.deserialize(jsonLogos);
        for (int i = 0; i < logos.size(); i++) {
            Logo logo = logos.get(i);
            logo.setWid(i);
            try {
                WebElement element = getDriver().findElement(Utilities.getLocator(${targetApplicationId}Page.brandElement, logo.getBrand(), logo.getBrand()));
                if (element != null) {
                    updateText(${targetApplicationId}Page.brandElement, logo.getBrand(), null, logo.getBrand(), logo.getBrand());
                }
            } catch (Exception e) {
                Context.getDataOutputProvider().writeFailedResult(Context.getDataInputProvider().getIndexData(Context.getCurrentScenarioData()).getIndexes().get(logo.getWid()),
                        Messages.FAIL_MESSAGE_DEFAULT + "Brand does not exist.");
            }
        }
    }

    @Alors("Je valide dans ${targetApplicationId.toUpperCase()}")
    @Then("I valide in ${targetApplicationId.toUpperCase()}")
    public void valid() throws FailureException {
        try {
            clickOn(${targetApplicationId}Page.validateButton);
        } catch (TechnicalException e) {
            new Result.Failure<>("${targetApplicationId.toUpperCase()}", TechnicalException.TECHNICAL_ERROR_MESSAGE + e.getMessage(), true, ${targetApplicationId}Page.getCallBack());
        }
    }

    @Alors("Je sauvegarde le score")
    @Then("I save score")
    public void saveScore() throws FailureException {
        try {
            WebElement message = Context.waitUntil(ExpectedConditions.presenceOfElementLocated(Utilities.getLocator(${targetApplicationId}Page.scoreMessage)));
            try {
                Context.getCurrentScenario().write("score is:\n" + message.getText());
                Context.getDataOutputProvider().writeDataResult("score", Context.getDataInputProvider().getIndexData(Context.getCurrentScenarioData()).getIndexes().get(0),
                        message.getText());
            } catch (TechnicalException e) {
                logger.error(TechnicalException.TECHNICAL_ERROR_MESSAGE + e.getMessage(), e);
            }
        } catch (Exception e) {
            new Result.Failure<>(e, "", true, ${targetApplicationId}Page.getCallBack());
        }
    }

}
