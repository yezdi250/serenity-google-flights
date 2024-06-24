package starter.actions;

import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.HomePage;

public class NavigateSteps extends UIInteractionSteps {
    HomePage homePage;
    @Step("User opens the home page")
    public void opensTheHomePage(){
        homePage.open();
    }
}
