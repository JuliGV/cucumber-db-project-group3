package com.loop.step_definition;

import io.cucumber.java.en.*;

public class LoginStepDefs {
    @Given("User is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        System.out.println("This is given step");
    }
    @When("user enters user for client")
    public void user_enters_user_for_client() {
        System.out.println("This is when step");
    }
    @When("user enters password for client")
    public void user_enters_password_for_client() {
        System.out.println("This is when/and step");
    }
    @When("user clicks login button")
    public void user_clicks_login_button() {
        System.out.println("This is when/and step");
    }
    @Then("user should see home page for client")
    public void user_should_see_home_page_for_client() {
        System.out.println("This is then step");
    }
    @When("user enters user for employee")
    public void user_enters_user_for_employee() {
        System.out.println("This is when step employee");
    }
    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        System.out.println("This is when step employee");
    }
    @Then("user should see home page for employee")
    public void user_should_see_home_page_for_employee() {
        System.out.println("This is then step employee");
    }

    }
