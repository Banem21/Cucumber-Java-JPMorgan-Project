Feature: JPMorgan Logo Validation


   @search
  Scenario: Validate JP Morgan logo in google search
    Given A user navigates to Google HomePage
    And search bar is displayed
    Then page title is "Google"
    When a user searches for "J.P. Morgan"
    Then User clicks on the first link from the landing page
    Then User is navigated to the link and User validates the J.P. Morgan logo

  @search
  Scenario: Validate JP Morgan logo with different link than first link
    Given A user navigates to Google HomePage
    And search bar is displayed
    Then page title is "Google"
    When a user searches for "J.P. Morgan"
    Then User clicks on the other from the landing page
    Then User is navigated to the link and User validates the J.P. Morgan logo

