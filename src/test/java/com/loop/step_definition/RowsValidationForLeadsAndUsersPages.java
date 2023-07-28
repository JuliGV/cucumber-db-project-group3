package com.loop.step_definition;

import com.loop.pages.docuport.BasePage;
import com.loop.utilities.BrowsersUtility;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import static junit.framework.TestCase.assertEquals;

public class RowsValidationForLeadsAndUsersPages extends BasePage {

    private static final Logger LOG = LogManager.getLogger();

    @Then("user validates that Rows Per Page shows by default {int}")
    public void user_validates_that_rows_per_page_shows_by_default(Integer numOfRows) {
        assertEquals(numberOfRowsByDefaul.getText(),String.valueOf(numOfRows));
         LOG.info("Rows Per Page shows by default 10");

    }
    @When("user change Rows Per Page to {int}")
    public void user_change_rows_per_page_to(Integer numOfRows) {
        chooseNumOfPage((numOfRows));
        LOG.info("User chose 5 Rows Per Page");
    }

    @Then("user validates that Rows Per Page shows {int}")
    public void user_validates_that_rows_per_page_shows(Integer numOfRows) {
        assertEquals(numberOfRowsByDefaul.getText(),String.valueOf(numOfRows));
        LOG.info("Rows Per Page shows 5");
    }



}
