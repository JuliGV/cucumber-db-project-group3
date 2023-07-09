package com.loop.step_definition;

import com.loop.pages.google.GoogleSearchPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.junit.Assert;

import java.util.List;


public class GoogleSearchStepDefs {

    GoogleSearchPage googleSearchPage = new GoogleSearchPage();
    private static final Logger LOG = LogManager.getLogger();

    @Given("user is Google search page")
    public void user_is_google_search_page() {
        Driver.driver().get(ConfigurationReader.getProperty("googleURL"));

    }
    @When("user types Loop Academy in the google search box and clocks enter")
    public void user_types_loop_academy_in_the_google_search_box_and_clocks_enter() {
     googleSearchPage.searchBox.sendKeys("Loop Academy"+ Keys.ENTER);

    }
    @Then("user should see Loop Academy - Google Search in the google title")
    public void user_should_see_loop_academy_google_search_in_the_google_title() {
        Assert.assertEquals(Driver.driver().getTitle(),"Loop Academy - Google Search");
        LOG.info("User sees the result");

    }

    @Given("user is on Google search page")
    public void user_is_on_google_search_page() {
        Driver.driver().get(ConfigurationReader.getProperty("googleURL"));
        LOG.info(("User types input to google page"));
    }
    @When("user types {string} in the google search box and click enter")
    public void user_types_in_the_google_search_box_and_click_enter(String string) {
        googleSearchPage.searchBox.sendKeys(string+Keys.ENTER);
        LOG.info("User types input to Google page");
    }
    @Then("User should see {string} search is in the google title")
    public void user_should_see_search_is_in_the_google_title(String string) {
        Assert.assertEquals("Expected doesn't matching",Driver.driver().getTitle(),string);

    }
    @Then("user searches the following items")
    public void user_searches_the_following_items(List<String> items) {
       items.forEach(p -> {
           googleSearchPage.searchBox.clear();
           googleSearchPage.searchBox.sendKeys(p+Keys.ENTER);
           Assert.assertEquals(p+" - Google Search",Driver.driver().getTitle());
       });
        for (String each:items) {
            googleSearchPage.searchBox.clear();
            googleSearchPage.searchBox.sendKeys(each+Keys.ENTER);
            Assert.assertEquals(each+" - Google Search",Driver.driver().getTitle());
        }
        //for(Map<String>)

    }
    @When("user searches for the {string}")
    public void user_searches_for_the(String country) {
     googleSearchPage.searchBox.sendKeys("What is the capital of "+country +Keys.ENTER);
     LOG.info("User search for a country");
    }
    @Then("user should see the {string} in the result")
    public void user_should_see_the_in_the_result(String capital) {
     Assert.assertEquals(googleSearchPage.capital.getText(),capital);
     LOG.info("User sees the capital");
    }


}
