package com.loop.step_definition;

import com.google.common.base.Verify;
import com.loop.pages.smartBear.SmartBearLoginPage;
import com.loop.pages.smartBear.SmartBearOrderPage;
import com.loop.pages.smartBear.ViewAllOrderPage;
import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SmartBearStepDefs {

    SmartBearLoginPage loginPage = new SmartBearLoginPage();
    SmartBearOrderPage orderPage = new SmartBearOrderPage();
    ViewAllOrderPage viewAllOrderPage = new ViewAllOrderPage();

    @Given("user is already logged in and navigated to order page")
    public void user_is_already_logged_in_and_navigated_to_order_page() {
        Driver.driver().get(ConfigurationReader.getProperty("smart.bear"));
        loginPage.login(ConfigurationReader.getProperty("smart.username"), ConfigurationReader.getProperty("smart.password"));
        Assert.assertTrue(loginPage.webOrders.isDisplayed());
        BrowsersUtility.clickWithJS(loginPage.orderLink);
        Assert.assertTrue(orderPage.orderHeader.isDisplayed());


    }

    @When("user selects product type {string}")
    public void user_selects_product_type(String productType) {
        Select dropdown = new Select(orderPage.product);
        dropdown.selectByVisibleText(productType);
        Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), productType);

    }

    @When("user enters quantity {int}")
    public void user_enters_quantity(Integer input) {
        //orderPage.quantity.sendKeys(Keys.BACK_SPACE);
        orderPage.quantity.sendKeys(input.toString());
        //Assert.assertEquals("Expected doesn't matches with actual",input.toString(), orderPage.quantity.getText());
        //BrowsersUtility.clearAndSendKeysInt(orderPage.quantity,2);
    }

    @When("user enters customer name {string}")
    public void user_enters_customer_name(String name) {
        orderPage.customerName.sendKeys(name);
        //Assert.assertEquals("Expected doesn't matches with actual",orderPage.customerName.getText(), name);
    }

    @When("user enters street {string}")
    public void user_enters_street(String street) {
        orderPage.street.sendKeys(street);
        //Assert.assertEquals("Expected doesn't matches with actual",orderPage.street.getText(),street);

    }

    @When("user enters city {string}")
    public void user_enters_city(String city) {
    orderPage.city.sendKeys(city);
    //Assert.assertEquals("Expected doesn't matches with actual",orderPage.city.getText(),city);
    }

    @When("user enters state {string}")
    public void user_enters_state(String state) {
     orderPage.state.sendKeys(state);
     //Assert.assertEquals("Expected doesn't matches with actual",orderPage.state.getText(),state);
    }

    @When("user enters zip {string}")
    public void user_enters_zip(String zip) {
     orderPage.zip.sendKeys(zip);
     //Assert.assertEquals("Expected doesn't matches with actual",orderPage.zip.getText(),zip);
    }

    @When("user selects credit card type {string}")
    public void user_selects_credit_card_type(String cardType) {
     orderPage.cardType.stream()
             .filter(element -> element.getAttribute("value").equals(cardType))
             .findFirst().ifPresent(WebElement::click);
    }

    @When("user enters credit car number {string}")
    public void user_enters_credit_car_number(String cardNum) {
     orderPage.cardNum.sendKeys(cardNum);
     //Assert.assertEquals(orderPage.cardNum.getText(),cardNum);
    }

    @When("user enters expiration date {string}")
    public void user_enters_expiration_date(String exppDate) {
     orderPage.expDate.sendKeys(exppDate);
     //Assert.assertEquals(orderPage.expDate.getText(),exppDate);
    }

    @When("user enters process order button")
    public void user_enters_process_order_button() {

        orderPage.processBtn.click();
    }

    @Then("user should see all inputted information in the first row of the table")
    public void user_should_see_all_inputted_information_in_the_first_row_of_the_table(List<String> list) {
        orderPage.viewAllOrdersLink.click();

        List<String> actual = viewAllOrderPage.valueOfFirstRow.stream()
                .map(WebElement::getText).collect(Collectors.toList());

        for (int i = 0; i < actual.size()-1; i++) {
            Assert.assertEquals(actual.get(i), list.get(i));

        }


    }



}
