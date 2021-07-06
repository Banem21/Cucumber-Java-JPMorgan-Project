package com.automatedtest.sample.homepage;

import com.automatedtest.sample.searchresultpage.SearchResultPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.junit.Assert;

public class HomePageSteps {


    private HomePage homePage;
    private SearchResultPage searchResultPage;

    public HomePageSteps() {
        this.homePage = new HomePage();
        this.searchResultPage=new SearchResultPage();

    }

    @Given("A user navigates to Google HomePage")
    public void a_user_navigates_to_Google_HomePage() {
        try {
            this.homePage.goToHomePage();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @Given("search bar is displayed")
    public void search_bar_is_displayed() {
        try {
            this.homePage.checkSearchBarDisplay();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Then("page title is {string}")
    public void page_title_is(String title) {
        String displayedTitle = this.homePage.getTitle();
        try {
            Assert.assertEquals(title, displayedTitle);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    @When("a user searches for {string}")
    public void a_user_searches_for(String searchValue) {
        try {
            this.homePage.searchFor(searchValue);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @Then("User clicks on the first link from the landing page")
    public void user_clicks_on_the_first_link_from_the_landing_page() {
        try {
            this.searchResultPage.clickOnLink(0);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }



    @Then("User is navigated to the link and User validates the J.P. Morgan logo")
    public void user_is_navigated_to_the_link_and_User_validates_the_J_P_Morgan_logo() {

        String url =searchResultPage.getJPMorganURL();
        try {
            if (url.equalsIgnoreCase("https://www.jpmorgan.com/global"))
                Assert.assertTrue(this.searchResultPage.isLogoDisplayed());
            else
                System.out.println("URL not matching. cannot validate logo");
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }


    @Then("User clicks on the other from the landing page")
    public void user_clicks_on_the_other_from_the_landing_page() {
        try
        {
            searchResultPage.clickOnLink(3);

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }

//    @Then("User is navigated to the link and User validates the J.P. Morgan logo is not found")
//    public void user_is_navigated_to_the_link_and_User_validates_the_J_P_Morgan_logo_is_not_found() {
//
//    }



}
