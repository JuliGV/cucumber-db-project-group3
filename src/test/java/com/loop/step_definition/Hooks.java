package com.loop.step_definition;

import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    @Before// io.cucumber.java
    public void setUp(Scenario scenario){
        Driver.driver();
        BrowsersUtility.myScenario = scenario;
    }
    @After
    public void tearDown(Scenario scenario) {
        // only do screenshot if scenario is failed
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }


}
