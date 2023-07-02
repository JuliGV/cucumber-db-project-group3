package com.loop.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
    Creating the private constructor so this class object is not reachable from outside
     */

    private Driver(){}
    /*
    Making drivr instance private
    Static run beore everything else and also use static method
     */
     private static WebDriver driver;
     /*
     Reusable method that will return the same driver instance every time when called
      */

    /**
     * singelton pattern
     * @return driver
     * @autor Yuliia
     */
    public static WebDriver driver(){
        if(driver==null){
            String browserType = ConfigurationReader.getProperty("browser");
            switch (browserType.toLowerCase()){
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }
        return driver;
    }

    /**
     * @closing driver
     */
    public static void closeDriver(){
        if(driver!=null){
            driver.quit();
            driver = null;
        }
    }
}
