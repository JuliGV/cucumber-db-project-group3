package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.Set;

public class BrowsersUtility {

    /**
     *
     */

    public static void switchWindowAndValidate(WebDriver driver, String expectedTitle,String expectedUrl){
        expectedUrl = expectedUrl.toLowerCase();
         expectedTitle = expectedTitle.toLowerCase();
        Set<String> windowsHandles = driver.getWindowHandles();
        for (String each : windowsHandles) {
            driver.switchTo().window(each);
            if(driver.getCurrentUrl().toLowerCase().contains(expectedUrl)){
                break;
            }

        }
        Assert.assertTrue(driver.getTitle().toLowerCase().contains(expectedTitle));
    }

    public static void switchToWindow(WebDriver driver,String expectedTitle){
        String origin = driver.getWindowHandle();
        for (String handel : driver.getWindowHandles()){
            driver.switchTo().window(handel);
            if(driver.getTitle().contains(expectedTitle)){
                return;
            }
        }
        driver.switchTo().window(origin);
    }

    public static void validateTitle(WebDriver driver,String expectedTitle){
        Assert.assertTrue(driver.getTitle().contains(expectedTitle));
    }

    /**
     *

     @param nameOfthePage from loop practice page
     once you on the page call it
     @nsh*/
    public static void loopLinkClick(String nameOfthePage){
        WebElement element = Driver.driver().findElement(By.xpath("//a[.='" + nameOfthePage + "']"));
        WebDriverWait wait = new WebDriverWait(Driver.driver(), Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();}

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
     * @param element
     */
    public static void hoverOverElement(WebElement element){
        Actions action = new Actions(Driver.driver());
        action.moveToElement(element).perform();
    }

    /**
     * scroll to element
     * @param element
     */
    public static void scrollToElement(WebElement element){
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].scrollIntoView(true);",element);
    }

    /**
     * scroll and click with JSExecutor
     * @param element
     */
    public static void scrollAndClick(WebElement element){
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].scrollIntoView(true);",element);
        ((JavascriptExecutor) Driver.driver()).executeScript("arguments[0].click;",element);
    }

    /**
     * this method will double click  any given element
     * @param element
     */
    public static void doubleClick(WebElement element){
       new Actions(Driver.driver()).doubleClick().perform();
    }

    /**
     * waits for providing element to be visible
     * @param element
     * @param timeToWaitSec
     * @return element
     * @author Yuliia
     */
    public static WebElement waitForVisibility(WebElement element,int timeToWaitSec){
        WebDriverWait wait = new WebDriverWait(Driver.driver(),Duration.ofSeconds(timeToWaitSec));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    /**
     * waits for providing element to be not visible
     * @param element
     * @param timeToWait
     *
     * @author Yuliia
     */
    public static void waitForInvisibility(WebElement element,int timeToWait){
        WebDriverWait wait = new WebDriverWait(Driver.driver(),Duration.ofSeconds(timeToWait));
         wait.until(ExpectedConditions.invisibilityOf(element));
    }

    /**
     * wait untill the element become clickable
     * @param element
     * @param timeOut
     * @return
     * @author Yuliia
     */
    public static WebElement waitForClickable(WebElement element,int timeOut){
        WebDriverWait wait = new WebDriverWait(Driver.driver(),Duration.ofSeconds(timeOut));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * perform pause
     * @param seconds
     */
    public static void justWait(int seconds){
        try{
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
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

    public static void dragAndDrop(WebElement dragElement,WebElement dropToElement){
         new Actions(Driver.driver()).dragAndDrop(dragElement,dropToElement).perform();
    }





}