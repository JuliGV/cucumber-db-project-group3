package com.loop.step_definition;

import com.loop.pages.google.WikipediaSearchPage;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class WikipediaSearchStepDefs {


   WikipediaSearchPage wikipediaSearchPage = new WikipediaSearchPage();

    @Given("User is on Wikipedia home page")
    public void user_is_on_wikipedia_home_page() {
        Driver.driver().get("https://www.wikipedia.org/");
    }
    @When("User types name in the wiki search box")
    public void user_types_name_in_the_wiki_search_box(String input) {
      wikipediaSearchPage.searchBox.sendKeys(input);
    }

    @When("User clicks wiki search button")
    public void user_clicks_wiki_search_button() {
     wikipediaSearchPage.searchBtn.click();
    }


    @Then("User sees Steve Jobs is in the {string},{string},{string}")
    public void user_sees_is_in_the(String title, String header,String imageHeader) {
        Assert.assertTrue("Title is not matches with expected",Driver.driver().getTitle().contains(title));
        Assert.assertTrue("Title is not matches with expected",wikipediaSearchPage.header.getText().contains(header));
        Assert.assertTrue("Title is not matches with expected",wikipediaSearchPage.imageHeader.getText().contains(imageHeader));
    }

}
