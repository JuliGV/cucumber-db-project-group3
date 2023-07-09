package com.loop.step_definition;

import com.loop.pages.docuport.BasePage;
import com.loop.pages.docuport.LoginPage;
import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class DocuportLeftMenuStepDefs extends BasePage {
    LoginPage loginPage = new LoginPage();
    String username = "";

    @When("user enters credentials {string} and {string} for each role")
    public void userEntersCredentialsAndForEachRole(String username, String password) {
        this.username = username;
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
    }

    @Then("validate all text for left menu links")
    public void validate_all_text_for_left_menu_links(List<Map<String, String>> roles) {
        for (Map<String, String> role : roles) {
            switch (username) {
                case "b1g3_advisor@gmail.com":
                    System.out.println(getTextMenuLinks(role.get("advisor")));
                    Assert.assertEquals(getTextMenuLinks(role.get("advisor")), role.get("advisor"));
                    break;
                case "b1g3_client@gmail.com":
                    if (role.get("client") == null) {
                        break;
                    } else {
                        System.out.println(getTextMenuLinks(role.get("client")));
                        Assert.assertEquals(getTextMenuLinks(role.get("client")), role.get("client"));
                    }
                    break;
                case "b1g3_supervisor@gmail.com":
                    if (role.get("supervisor") == null) {
                        break;
                    } else {
                        System.out.println(getTextMenuLinks(role.get("supervisor")));
                        Assert.assertEquals(getTextMenuLinks(role.get("supervisor")), role.get("supervisor"));
                    }
                    break;
                case "b1g3_employee@gmail.com":
                    if (role.get("employee") == null) {
                        break;
                    } else {
                        System.out.println(getTextMenuLinks(role.get("employee")));
                        Assert.assertEquals(getTextMenuLinks(role.get("employee")), role.get("employee"));
                    }
                    break;
            }
        }
    }
}
