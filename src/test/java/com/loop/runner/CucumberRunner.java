package com.loop.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/html-reports/cucumber-reports.html", // (generate) give us a report, that we can open in browser
        "json:target/json-report/json-report"},// uplod reports in Xray(json )
        features = "src/test/resources/feature",// point to location of feature class
        glue = "com/loop/step_definition", // point to location of step defenition file
        dryRun = false,// care only snippet has implementation, give us snippets
        tags = "@wip", // run 2 of them (run scenario that have smoke or regression
        monochrome = true // reduce unnecessary tags, make your scenario more readable
        //tags = "@smoke or @regression or @wip"// run 3 of them (run scenario that have smoke or regression or wip - working process tag
        //tags = "@smoke and @regression"// run nothing, because check if all scenario have a 2 tags, if scenario has 2 tags it will run
        //tags = "@smoke or not @regression" // run only scen that has @smog tag, only smoke!
        //tags = "@smoke and  @regression and not @wip"


)

public class CucumberRunner {
}
