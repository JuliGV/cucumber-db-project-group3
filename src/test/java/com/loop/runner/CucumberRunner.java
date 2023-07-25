package com.loop.runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
         // (generate) give us a report, that we can open in browser
               // upload reports in Xray(json )

        plugin = {"html:target/html-reports/cucumber-reports.html",
                "json:target/json-reports/json-report",
                "rerun:target/rerun.txt",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = "src/test/resources/feature",
        glue = "com/loop/step_definition",
        dryRun = false,
        tags = "@smoke",
        monochrome = true


)

public class CucumberRunner {
}
