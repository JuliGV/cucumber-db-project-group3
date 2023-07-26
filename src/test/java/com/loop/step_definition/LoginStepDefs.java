package com.loop.step_definition;

import com.loop.pages.docuport.HomePage;
import com.loop.pages.docuport.LoginPage;
import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.DocuportConstants;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.io.IOException;
import java.util.Map;

public class LoginStepDefs {

    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();

    @Given("User is on Docuport login page")
    public void user_is_on_docuport_login_page() {
        Driver.driver().get(ConfigurationReader.getProperty("env"));
    }

    @When("user enters user for client")
    public void user_enters_user_for_client() {

        loginPage.usernameBox.sendKeys(DocuportConstants.USERNAME_CLIENT);
    }

    @When("user enters password for client")
    public void user_enters_password_for_client() {
        loginPage.passwordBox.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
    }

    @When("user clicks login button")
    public void user_clicks_login_button() {

        loginPage.loginBtn.click();
    }

    @Then("user should see home page for client")
    public void user_should_see_home_page_for_client() throws IOException {
        Assert.assertTrue(homePage.homeIcone.isDisplayed());
//        //screenshot for specified element
//        File file = homePage.homeIcone.getScreenshotAs(OutputType.FILE);
//        File destFile = new File("homeIcone.png");
//        FileUtils.copyFile(file, destFile);


    }

    @When("user enters user for employee")
    public void user_enters_user_for_employee() {

        loginPage.usernameBox.sendKeys(DocuportConstants.USERNAME_EMPLOYEE);
    }

    @When("user enters password for employee")
    public void user_enters_password_for_employee() {
        loginPage.passwordBox.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
    }

    @Then("user should see home page for employee")
    public void user_should_see_home_page_for_employee() {
        BrowsersUtility.waitForClickable(homePage.userMenuBtn, 10);
        homePage.userMenuBtn.click();
      BrowsersUtility.waitForVisibility(homePage.profileOption, 15);
        homePage.profileOption.click();
        Assert.assertEquals(homePage.emailAddressValue.getText(), "b1g3_employee@gmail.com");
    }

    @When("user enters user for advisor")
    public void user_enters_user_for_advisor() {
        loginPage.usernameBox.sendKeys(DocuportConstants.USERNAME_ADVISOR);
    }

    @When("user enters password for advisor")
    public void user_enters_password_for_advisor() {
        loginPage.passwordBox.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
    }

    @Then("user should see home page for advisor")
    public void user_should_see_home_page_for_advisor() throws InterruptedException {
        BrowsersUtility.waitForClickable(homePage.userMenuBtn, 10);
        homePage.userMenuBtn.click();
//        BrowsersUtility.waitForVisibility(loginPage.profileOption,15);
        Thread.sleep(3000);
        homePage.profileOption.click();
        Assert.assertEquals(homePage.emailAddressValue.getText(), "b1g3_advisor@gmail.com");
    }

    @When("user enters user for admin")
    public void user_enters_user_for_admin() {

        loginPage.usernameBox.sendKeys(DocuportConstants.USERNAME_SUPERVISOR);
    }

    @When("user enters password for admin")
    public void user_enters_password_for_admin() {
        loginPage.passwordBox.sendKeys(DocuportConstants.PASSWORD_DOCUPORT);
    }

    @Then("user should see home page for admin")
    public void user_should_see_home_page_for_admin() {
        BrowsersUtility.waitForClickable(homePage.userMenuBtn, 10);
        homePage.userMenuBtn.click();
        BrowsersUtility.waitForVisibility(homePage.profileOption, 10);
        homePage.profileOption.click();
        Assert.assertEquals(homePage.emailAddressValue.getText(), "b1g3_supervisor@gmail.com");
    }

    @When("user enters credentions")
    public void user_enters_credentions(Map<String,String> credentional) {
//        for (Map.Entry<String, String> entry : credentional.entrySet()) {
//            String key = entry.getKey();
//            String value = entry.getValue();
//
//        }
        loginPage.loginDocuport(credentional.get("username"),credentional.get("password"));
    }
    @When("user enters credentials {string} and {string}")
    public void user_enters_credentials_and(String username,String password) {
        loginPage.loginDocuport(username,password);
    }
    @Then("user should see home page")
    public void user_should_see_home_page() {
        Assert.assertTrue(homePage.homeIcone.isDisplayed());
    }






}
