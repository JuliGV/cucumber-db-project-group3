package com.loop.step_definition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import com.loop.utility_db.DBUtility;
import org.junit.Assert;

import java.util.List;

public class Test00StepDefs {
    List<String> actualList;

    @Given("Establish database connection")
    public void establish_database_connection() {
        System.out.println("Connections is handled ");

    }

    @When("Execute query to get all columns from {string}")
    public void execute_query_to_get_all_columns_from(String string) {
        DBUtility.runQuery("SELECT * from identity." + string);
       actualList = DBUtility.getColumnDataAsList("name");
    }
    @Then("verify the below column sare listed in result for")
    public void verify_the_below_column_sare_listed_in_result_for(List<String> expected) {
        Assert.assertEquals(actualList,expected);
        //System.out.println(expected);


    }
}
