package com.loop.step_definition;

import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;



public class Hooks {

    private static final Logger LOG = LogManager.getLogger();

    @Before// io.cucumber.java
    public void setUp(Scenario scenario){
        Driver.driver();
        BrowsersUtility.myScenario = scenario;
        LOG.info("...........START AUTOMATION.......LOOP ACADEMY......");
    }
    @After
    public void tearDown(Scenario scenario) {
        // only do screenshot if scenario is failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
        LOG.info("...........END AUTOMATION.......LOOP ACADEMY.....");
    }




}
