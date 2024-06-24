package starter.pageobjects;

import net.serenitybdd.annotations.DefaultUrl;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actions.Clear;
import net.serenitybdd.screenplay.actions.SendKeys;
import net.serenitybdd.screenplay.actions.SendKeystoElement;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.stepdefinitions.HomePageStepDefinitions;

import javax.xml.xpath.XPath;

@DefaultUrl("https://www.google.com/travel/flights")
public class HomePage extends PageObject {
    @FindBy(css = "input[aria-label='Where from?']")
    WebElementFacade originTxtBox;
    @FindBy(css = "input[aria-label*='Where to?']")
    WebElementFacade destinationTxtBox;
    @FindBy(xpath = "//input[@aria-label='Departure']")
    WebElementFacade depDateInput;
    @FindBy(xpath = "//input[@placeholder='Return']")
    WebElementFacade retDateInput;
    @FindBy(xpath = "//button[contains(@aria-label, 'Done')]/span")
    WebElementFacade datePopupDonebutton;

    @FindBy(css = "div[aria-label*='Enter your destination'] li")
    WebElementFacade departureOptions;

    @FindBy(css = "div[aria-label*='Enter your origin'] li")
    WebElementFacade originOptions;

    @FindBy(xpath = "//span[contains(text(),'Search')]")
    WebElementFacade searchButton;


    public HomePage enterOrigin(String origin) {
        typeInto(originTxtBox, origin);
        originOptions.waitUntilClickable().click();
        return this;
    }

    public HomePage enterDestination(String destination) {
        typeInto(destinationTxtBox, destination);
        departureOptions.waitUntilClickable().click();
        return this;
    }

    public HomePage enterDepDate(String depDate) {
        depDateInput.waitUntilClickable().click();
        waitABit(1500);
        typeInto(depDateInput, depDate);
        datePopupDonebutton.waitUntilClickable().click();
        return this;
    }

    public HomePage enterRetDate(String retDate) {
        retDateInput.waitUntilClickable().click();
        typeInto(retDateInput, retDate);
        datePopupDonebutton.waitUntilClickable().click();
        return this;
    }

    public HomePage clickDoneOnCalendar() {
        datePopupDonebutton.waitUntilClickable().click();
        return this;
    }

    public HomePage clickSearchButton(){
        searchButton.waitUntilClickable().click();
        return this;
    }
}
