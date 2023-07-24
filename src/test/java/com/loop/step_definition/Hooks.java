package com.loop.step_definition;

import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.ConfigurationReader;
import com.loop.utilities.Driver;
import com.loop.utility_db.DBUtility;
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

    @Before //("@db")
    public void setUpDB() {
        String ip = ConfigurationReader.getProperty("docuportURL");
        String un = ConfigurationReader.getProperty("username");
        String pw = ConfigurationReader.getProperty("passwordDB");
        DBUtility.createConnection(ip, un, pw);
    }

    @After //("@db")
    public void tearDownDB() {
        DBUtility.destroy();
    }




}
