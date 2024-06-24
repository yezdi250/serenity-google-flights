Feature: Google flight search

  Background: User starts from the google flights search website
    Given Sally is on the google flights search website

  @roundtrip
  Scenario Outline: Sally searches for a round trip
    When Sally searches for round trip flight
      | Origin        | <origin>       |
      | Destination   | <destination>  |
      | Departure Day | <departureDay> |
      | Return Day   | <returnDay>   |
    Then Sally should see flights results page with "Best departing flights"
    When Sally selects the "1" flight under best flights
    Then Sally should see flights results page with "Returning flights"
    When Sally selects the "1" flight under best flights
    Then Sally should see flights results page with "Booking options"
    And Sally should see the corresponding flight information for flights selected
      | Origin        | <origin>       |
      | Destination   | <destination>  |

    Examples:
      | origin    | destination | departureDay  | returnDay    |
      | Sydney    | New York    | 10 days later | 30 days later |
      | Singapore | Sydney      | 7 days later  | 21 days later |


