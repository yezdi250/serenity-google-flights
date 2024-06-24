package starter.actions;

import io.cucumber.datatable.DataTable;
import net.serenitybdd.annotations.Step;
import net.serenitybdd.core.steps.UIInteractionSteps;
import starter.pageobjects.SearchResults;


import java.util.Collection;
import java.util.List;
import java.util.Map;



import static org.hamcrest.CoreMatchers.containsStringIgnoringCase;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchResultsSteps extends UIInteractionSteps {
    SearchResults searchResults;
    @Step("Verify user should see flights results")
    public void verifyUserShouldSeeFlightsResultsPageWith(String sectionTitle) {
        assertThat(searchResults.getSearchResultHeading(sectionTitle),containsStringIgnoringCase(sectionTitle));
    }

    @Step("Select Flight from the best flight list")
    public void selectFlightByIndex(Integer index){
        searchResults.selectFlightInBestFlights(index);
    }

    @Step("Verify travel details")
    public void VerifyTravelDetails(DataTable travelDetails){
        /*Collection<String> valueList = travelDetails.asMap().values();
        for(String value: valueList){
            assertThat(searchResults.verifyIfTextPresentOnScreen(value),is(Boolean.TRUE));
        }*/
        travelDetails.asMap()
                .values()
                .forEach(value -> assertThat(searchResults.verifyIfTextPresentOnScreen(value), is(Boolean.TRUE)));
    }
}
