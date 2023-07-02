package com.loop.step_definition;

import com.loop.pages.product.ProductPage;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import io.cucumber.java.en.*;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class ProductStepDefs {

    ProductPage productPage = new ProductPage();
    @Given("User is on the HomePage")
    public void user_is_on_the_home_page() {
        Driver.driver().get(ConfigurationReader.getProperty("product.url"));
    }
    @Then("User should be able to see expected prices in following products")
    public void user_should_be_able_to_see_expected_prices_in_following_products(List<Map<String,String>> products) {
        for (Map<String, String> product : products) {
            productPage.clickCategory(product.get("Category"));
            String actualPrice = productPage.getProductPrice(product.get("Product"));
            String expectedPrice = product.get("expectedPrice");
            Assert.assertEquals(actualPrice,expectedPrice);
        }
    }

    @Then("User should be able to see expected prices in following products with listOflist")
    public void user_should_be_able_to_see_expected_prices_in_following_products_with_list_oflist(List<List<String>> productDetails) throws InterruptedException {
        for (List<String> detail : productDetails) {
            Thread.sleep(3000);
            productPage.clickCategory(detail.get(0));// click on category( first column)
            Assert.assertEquals(productPage.getProductPrice(detail.get(1)),detail.get(2));

//            String actualPrice = productPage.getProductPrice(detail.get(1));// get second
//            String expectedPrice = detail.get(2);


        }
    }

    @Then("User should be able to see following names in their groups")
    public void user_should_be_able_to_see_following_names_in_their_groups(Map<String,List<String>>  students) {
        List<String> group1 = students.get("Group1");
        List<String> group2 = students.get("Group2");
        List<String> group3 = students.get("Group3");
        System.out.println(group1);
        System.out.println(group2);
        System.out.println(group3);


    }

}
