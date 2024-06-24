package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import net.serenitybdd.annotations.Steps;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import starter.actions.FlightSearchSteps;
import starter.actions.NavigateSteps;

public class HomePageStepDefinitions {

    Logger LOGGER = LoggerFactory.getLogger(HomePageStepDefinitions.class);
    @Steps
    NavigateSteps navigate;

    @Steps
    FlightSearchSteps flightSearch;

    @Given("^(?:.*) is on the google flights search website")
    public void sallyIsOnTheGoogleFlightsSearchWebsite() {
        navigate.opensTheHomePage();
        LOGGER.info("Home Page Opened");
    }

    @When("^(?:.*) searches for round trip flight")
    public void sallySearchesForRoundTripFlight(DataTable searchParams) {
        flightSearch.searchRoundTripFlights(searchParams);
    }
}
