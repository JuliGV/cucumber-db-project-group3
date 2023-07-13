package com.loop.step_definition;

import com.loop.pages.docuport.HomePage;
import io.cucumber.java.en.*;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.assertj.core.api.SoftAssertions;


public class ClientChooseAccountStepDefs {

    HomePage homePage = new HomePage();
    private static final Logger LOG = LogManager.getLogger();
    private final SoftAssertions softAssertions = new SoftAssertions();

    @When("user validates if pop-up is visible")
    public void user_validates_if_pop_up_is_visible() {
//        assert homePage.dropdownIsDisplayed.isDisplayed();
//        Assert.assertTrue(homePage.dropdownIsDisplayed.getText().equals("Choose account"));
        softAssertions.assertThat(homePage.dropdownTextIsDisplayed.getText()).isEqualTo("Choose account");
        System.out.println(homePage.dropdownTextIsDisplayed.getText());
        LOG.info("Choose account text is displayed");

    }
    @When("user chooses account from dropdown {string}")
    public void user_chooses_account_from_dropdown(String account) {
        homePage.accountDropdown.click();
        softAssertions.assertThat(homePage.continueBtn.isDisplayed()).isTrue();
        homePage.chooseAccountFromDropdpwn(account);
        homePage.continueBtn.click();
        softAssertions.assertAll();
    }
}
