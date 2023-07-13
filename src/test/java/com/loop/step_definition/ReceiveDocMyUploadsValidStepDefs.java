package com.loop.step_definition;

import com.loop.pages.docuport.BasePage;
import com.loop.pages.docuport.MyUploadsPage;
import com.loop.pages.docuport.ReceiveDocPage;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class ReceiveDocMyUploadsValidStepDefs extends BasePage {
    ReceiveDocPage receiveDocPage = new ReceiveDocPage();
    private static final Logger LOG = LogManager.getLogger();
    MyUploadsPage myUploadsPage = new MyUploadsPage();


    @When("user clicks on {string} button")
    public void userClicksOnButton(String buttonName) {
        clickOnButton(buttonName);
    }

    @Then("validate if  {string} button is displayed on Receive docs page")
    public void validate_if_button_is_displayed_on_receive_docs_page(String search) {
        receiveDocPage.checkIfDisplayedBtn(search);
        LOG.info("Search button is displayed Received doc");

    }
    @Then("validate if {string} button is displayed")
    public void validate_if_button_is_displayed(String download) {
       receiveDocPage.checkIfDisplayedBtn(download);
        LOG.info("Download button is displayed from Received doc");

    }
    @Then("validate if Receive docs header is displayed")
    public void validate_if_receive_docs_header_is_displayed() {
        assert receiveDocPage.receivedDocHeader.isDisplayed();
    }

    @When("validate if {string} button on My uploads page  is displayed")
    public void validate_if_button_on_my_uploads_page_is_displayed(String searchBtnName) {
        myUploadsPage.checkIfDisplayedBtn(searchBtnName);
        LOG.info("Search button is displayed from My uploads page");
    }
    @Then("validate if on My uploads page {string} button is displayed")
    public void validate_if_on_my_uploads_page_button_is_displayed(String downloadBtnName) {
      myUploadsPage.checkIfDisplayedBtn(downloadBtnName);
        LOG.info("Download button is displayed from My uploads page");
    }
    @Then("validate if My uploads is displayed")
    public void validate_if_my_uploads_is_displayed() {
        assert myUploadsPage.myUploadsHeader.isDisplayed();
    }

}

