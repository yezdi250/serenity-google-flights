package starter.pageobjects;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;

public class SearchResults extends PageObject {
    //@FindBy(xpath = "//h2[text()='Search results']/.. //h3")
    @FindBy(xpath = "//*[contains(text(),'Search results']")
    private WebElementFacade searcshResultHeading;
    private String searchResultHeading = "//*[contains(text(),'headerPlaceHolderText')]";
    private String flightListElement = "(//li[@class='pIav2d'])";

    public String getSearchResultHeading(String heading) {
        return $(By.xpath(searchResultHeading
                .replace("headerPlaceHolderText", heading)))
                .getText();

    }

    public void selectFlightInBestFlights(Integer index) {
        $(By.xpath(flightListElement + "[" + index + "]"))
                .waitUntilClickable()
                .click();
    }

    public boolean verifyIfTextPresentOnScreen(String input){
        return $(By.xpath("//span[contains(text(),'" + input + "')]")).isDisplayed();
    }
}
