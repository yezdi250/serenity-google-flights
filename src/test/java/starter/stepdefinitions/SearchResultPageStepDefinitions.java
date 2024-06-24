package starter.stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import starter.actions.SearchResultsSteps;
import starter.pageobjects.SearchResults;

public class SearchResultPageStepDefinitions {
    SearchResultsSteps searchResultsSteps;

    @Given("^(?:.*) should see flights results page with \"([^\"]*)\"$")
    public void userShouldSeeFlightResultsPageWith(String sectionTitle) {
        searchResultsSteps.verifyUserShouldSeeFlightsResultsPageWith(sectionTitle);
    }

    @When("Sally selects the {string} flight under best flights")
    public void sallySelectsTheFlightUnderBestFlights(String index) {
        searchResultsSteps.selectFlightByIndex(Integer.parseInt(index));
    }

    @And("^(?:.*) should see the corresponding flight information for flights selected")
    public void sallyShouldSeeTheCorrespondingFlightInformationForFlightsSelected(DataTable expectedTravelDetails) {
        searchResultsSteps.VerifyTravelDetails(expectedTravelDetails);
    }



}
