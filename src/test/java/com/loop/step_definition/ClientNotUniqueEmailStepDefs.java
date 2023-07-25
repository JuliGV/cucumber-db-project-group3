package com.loop.step_definition;

import com.loop.pages.docuport.BasePage;
import com.loop.pages.docuport.ClientsPage;
import com.loop.utilities.BrowsersUtility;
import io.cucumber.java.en.*;
import org.junit.Assert;

public class ClientNotUniqueEmailStepDefs extends BasePage {

    ClientsPage clientsPage = new ClientsPage();
    String personal;

    @When("user is on {string} page")
    public void user_is_on_page(String clients) {

        clickLeftMenuBtn(clients);
    }

    @When("user click on create new client button and choose {string} option")
    public void user_click_on_create_new_client_button_and_choose_option(String personal) {
        this.personal = personal;
        clientsPage.createNewClientBtn.click();
        clientsPage.clickTypeOfClient(personal);
    }

    @When("user creates new client with test@gmail.com email")
    public void user_creates_new_client_with_test_gmail_com_email() {
        sendKeysToFirstOrLastName("First name","ATest11");
        sendKeysToFirstOrLastName("Last name","Test11");
        clientsPage.ownerDropdown.click();
        clientsPage.ownerSendKeys.sendKeys("Test Test");
        clientsPage.testTestUser.click();
        clientsPage.saveBtn.click();
        clientsPage.advisorDrop.click();
        clientsPage.advisorDropdown.click();
        clientsPage.servicesDrop.click();
        clientsPage.servicesTax.click();
        BrowsersUtility.waitForClickable(clientsPage.saveBtn,15).click();
    }

    @When("user creates one more client with the same  email test@gmail.com")
    public void user_creates_one_more_client_with_the_same_email_test_gmail_com() {
        clientsPage.createNewClientBtn.click();
        clientsPage.clickTypeOfClient(personal);
        sendKeysToFirstOrLastName("First name","ATest22");
        sendKeysToFirstOrLastName("Last name","Test22");
        clientsPage.ownerDropdown.click();
        clientsPage.ownerSendKeys.sendKeys("Test Test");
        clientsPage.testTestUser.click();
        clientsPage.saveBtn.click();
        clientsPage.advisorDrop.click();
        clientsPage.advisorDropdown.click();
        clientsPage.servicesDrop.click();
        clientsPage.servicesTax.click();
        BrowsersUtility.waitForClickable(clientsPage.saveBtn,10).click();
    }

    @Then("validate if both clients have the same email {string}")
    public void validate_if_both_clients_have_the_same_email(String email) {
        Assert.assertEquals(clientsPage.returnValueOfRowTable("ATest11 Test11","email"),email);
        Assert.assertEquals(clientsPage.returnValueOfRowTable("ATest22 Test22","email"),email);
    }


}
