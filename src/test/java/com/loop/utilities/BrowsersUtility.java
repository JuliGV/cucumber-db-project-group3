package com.loop.utilities;

import io.cucumber.java.Scenario;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.sql.*;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Duration;
import java.util.*;

import java.util.stream.Collectors;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class BrowsersUtility {
    private static final Logger LOG = LogManager.getLogger();

    /**
     *
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedTitle, String expectedUrl) {
        expectedUrl = expectedUrl.toLowerCase();
        expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String each : windowsHandles) {
            driver.switchTo().window(each);
            if (driver.getCurrentUrl().toLowerCase().contains(expectedUrl)) {
                break;
            }

        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    public static void switchToWindow(WebDriver driver, String expectedTitle) {
        String origin = driver.getWindowHandle();
        for (String handel : driver.getWindowHandles()) {
            driver.switchTo().window(handel);
            if (driver.getTitle().contains(expectedTitle)) {
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static void validateTitle(WebDriver driver, String expectedTitle) {
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     * @param nameOfthePage from loop practice page
     *                      once you on the page call it
     * @nsh
     */
    public static void loopLinkClick(String nameOfthePage) {
        WebElement element = Driver.driver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

//    LoopPracticeDynamicLoading page;
//
//    @BeforeMethod
//    public void setUp(){
//        page = new LoopPracticeDynamicLoading();
//        Driver.getDriver().get(ConfigurationReader.getProperty("loop.practice"));
//    }
//
//    @Test
//    public void test_method(){
//        BrowserUtils.loopLinkClick("Context Menu");
//    }

    /**
     * method hover over
     *
     * @param element
     */
    public static void hoverOverElement(WebElement element) {
        Actions action = new Actions(Driver.driver());
        action.moveToElement(element).perform();
    }

    /**
     * Clicks on an element using JavaScript
     *
     * @param element
     * @author nsh
     */
    public static void clickWithJS(WebElement element) {
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].click();", element);
    }

    /**
     * scroll to element
     *
     * @param element
     */
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    /**
     * scroll and click with JSExecutor
     *
     * @param element
     */
    public static void scrollAndClick(WebElement element) {
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].scrollIntoView(true);", element);
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].click;", element);
    }

    /**
     * this method will double click  any given element
     *
     * @param element
     */
    public static void doubleClick(WebElement element) {
        new Actions(Driver.driver()).doubleClick().perform();
    }

    /**
     * waits for providing element to be visible
     *
     * @param element
     * @param timeToWaitSec
     * @return element
     * @author Yuliia
     */
    public static WebElement waitForVisibility(WebElement element, int timeToWaitSec) {
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * waits for providing element to be not visible
     *
     * @param element
     * @param timeToWait
     * @author Yuliia
     */
    public static void waitForInvisibility(WebElement element, int timeToWait) {
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(timeToWait));
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * wait untill the element become clickable
     *
     * @param element
     * @param timeOut
     * @return
     * @author Yuliia
     */
    public static WebElement waitForClickable(WebElement element, int timeOut) {
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * perform pause
     *
     * @param seconds
     */
    public static void justWait(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     */
    public static void selectCheckbox(WebElement element, boolean yesNot) {
        if (yesNot) {
            if (!element.isSelected()) {
                element.click();

            } else {
                if (element.isSelected()) {
                    element.click();
                }
            }
        }
    }

    public static void dragAndDrop(WebElement dragElement, WebElement dropToElement) {
        new Actions(Driver.driver()).dragAndDrop(dragElement, dropToElement).perform();
    }


    public static void screenshot(Scenario scenario) {
        if (!scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) Driver.driver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
            Driver.closeDriver();
        }


    }

    public static void takeScreenshot() {
        try {
            myScenario.log("Current url is: " + Driver.driver().getCurrentUrl());
            final byte[] screenshot = ((TakesScreenshot) Driver.driver()).getScreenshotAs(OutputType.BYTES);
            myScenario.attach(screenshot, "image/png", myScenario.getName());
        } catch (WebDriverException wbd) {
            wbd.getMessage();
        } catch (ClassCastException cce) {
            cce.getMessage();
        }
    }

    public static Scenario myScenario;

    /**
     * @Param element
     * @Param value
     * @Author darsmarsco
     */

    public static void clearAndSendKeysInt(WebElement element, int value) {
        // Clear the existing value by selecting all and deleting
        //element.sendKeys(Keys.CONTROL + "a");
        element.sendKeys(Keys.DELETE);

        // Convert the integer to a string and send it
        element.sendKeys(String.valueOf(value));
    }

    /**
     * @param elements
     * @return List<String>
     * @autor Yuliia
     */
    public static List<String> getElementsText(List<WebElement> elements) {

        List<String> list = new ArrayList<>();
        for (WebElement element : elements) {
            list.add(element.getText());
        }
        return list;
    }

    /**
     * @param elements
     * @return
     */
    public static List<String> getElementsWithStream(List<WebElement> elements) {
        return elements.stream()
                .map(x -> x.getText())
                .collect(Collectors.toList());
    }

    /**
     * @param elements
     * @return
     */
    public static List<String> getElementsWithStream2(List<WebElement> elements) {
        return elements.stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }

    public static void waitForStaleElement(WebElement element) {
        int y = 0;
        while (y <= 15) {
            try {
                element.isDisplayed();
                break;
            } catch (StaleElementReferenceException st) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } catch (WebDriverException we) {
                y++;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void waitUntilPageLoad() {
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(Integer.valueOf(ConfigurationReader.getProperty("timeout"))));
        wait.until((d) -> {
            Boolean isPageLoaded = (Boolean) ((JavascriptExecutor) Driver.driver())
                    .executeScript("return document.readyState").equals("complete");
            if (!isPageLoaded)
                LOG.info("Document is loading");
            return isPageLoaded;
        });
    }

    public static void createFileWithContent(String filePath, String content) {
        File file = new File(filePath);

        try {
            file.createNewFile();
            FileWriter fw = new FileWriter(file);
            try {
                fw.write(content);
            } catch (Exception e) {
                LOG.debug("Error during FileWriter append. " + e.getMessage(), e.getCause());
            } finally {
                try {
                    fw.close();
                } catch (Exception e) {
                    LOG.debug("Error during FileWriter close. " + e.getMessage(), e.getCause());
                }
            }

        } catch (IOException e) {
            LOG.debug(e.getMessage(), e.getCause());
        }
    }




}
