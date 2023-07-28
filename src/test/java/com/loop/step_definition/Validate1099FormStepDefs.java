package com.loop.step_definition;

import com.loop.pages.docuport.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class Validate1099FormStepDefs {

     BasePage basePage =new BasePage();
    @When("user should clicks on {int} From button")
    public void user_should_clicks_on_from_button(Integer int1) {
        basePage.form1099BtnLeftMenu.click();
    }

    @Then("user validates {int} Form button isDisplayed")
    public void user_validates_form_button_is_displayed(Integer int1) {
        assertTrue(basePage.form1099.isDisplayed());

    }

}