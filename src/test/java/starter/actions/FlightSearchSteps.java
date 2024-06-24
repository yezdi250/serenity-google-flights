package starter.actions;

import Utils.ExtractNumberDays;
import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.HomePage;

import java.util.Map;

import static Utils.DateUtils.calculateTravelDate;

public class FlightSearchSteps extends UIInteractionSteps {
    HomePage homePage;
    ExtractNumberDays extractNumberDays;

    @Step("User searches for round trip flight")
    public void searchRoundTripFlights(DataTable searchParams) {
        Map<String, String> searchParamsMap = searchParams.asMap();

        homePage.enterOrigin(searchParamsMap.get("Origin"))
                .enterDestination(searchParamsMap.get("Destination"))
                .enterDepDate(calculateTravelDate(searchParamsMap.get("Departure Day")))
                .enterRetDate(calculateTravelDate(searchParamsMap.get("Return Day")))
                .clickSearchButton();
    }
}
