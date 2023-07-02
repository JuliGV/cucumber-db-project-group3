package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.InputMismatchException;

public class DocuportUtils {

    /**
     * logins to Docuport app
     * @param driver, which initialized in test base
     * @param role, comes from DocuportConstans
     * @author Yuliia
     */
    public static void login(WebDriver driver, String role){
        Driver.driver().get(ConfigurationReader.getProperty("env"));

        WebElement userName = Driver.driver().findElement(By.cssSelector("input[type='text']"));

        WebElement password = Driver.driver().findElement(By.cssSelector("input[type='password']"));

        WebElement loginButton = Driver.driver().findElement(By.cssSelector("span[class='v-btn__content']"));

        switch (role.toLowerCase()){

            case "client":
                userName.sendKeys(ConfigurationReader.getProperty("client"));
                password.sendKeys(ConfigurationReader.getProperty("password"));

                break;
            case "advisor":
                userName.sendKeys(ConfigurationReader.getProperty("advisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));

                break;
            case "supervisor":
                userName.sendKeys(ConfigurationReader.getProperty("supervisor"));
                password.sendKeys(ConfigurationReader.getProperty("password"));

                break;
            case "employee":
                userName.sendKeys(ConfigurationReader.getProperty("employee"));
                password.sendKeys(ConfigurationReader.getProperty("password"));

                break;
            default: throw new InputMismatchException("Role is not correct.\nPlease enter one of the role: \n client,advisor,supervisor,employee");
        }
        loginButton.click();
    }


    /**
     * logsout from app
     * @param driver
     * @throws InterruptedException
     * @author Yuliia
     */
    public static void logout(WebDriver driver)  {
        WebElement userIcon = driver.findElement(By.xpath("//div[@class='v-avatar primary']"));
        userIcon.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement logOutButton = driver.findElement(By.xpath("//span[.='Log out']"));

        logOutButton.click();

    }

    public static void Select(WebDriver driver,String email){

        WebElement checkbox = driver.findElement(By.xpath("//td[contains(text(),'"+email+"')]/../td/div/div/div"));
        checkbox.click();

        }


        public static void PaymentPage1(WebDriver driver,String field,String value){

           WebElement element =null;

           switch(field.toLowerCase()){
               case "legal company name" :
                   element = driver.findElement(By.xpath("(//div/label[.='Legal Company Name  *']/following::input)[1]"));

                   break;
               case "first name":
                   element = driver.findElement(By.xpath("(//label[.='First name *']/following-sibling::input)[1]"));
                   break;
               case "last name":
                   element = driver.findElement(By.xpath("(//label[.='Last name *']/following-sibling::input)[1]"));
                   break;
               case "email address":
                   element = driver.findElement(By.xpath("(//label[.='Email address *']/following-sibling::input)[1]"));
                   break;
               case "phone number":
                   element = driver.findElement(By.xpath("(//label[.='Phone number *']/following-sibling::input)[1]"));
                   break;
           }
            element.sendKeys(value);
        }

    public static void PaymentPage2(WebDriver driver,String field,String value){
        WebElement element = null;

        switch(field.toLowerCase()){
            case "company name" :
                element = driver.findElement(By.xpath("(//label[.='Company name *']/following::input)[1]"));
//                element.sendKeys(value);
                break;
            case "address line 1":
                element = driver.findElement(By.xpath("(//label[.='Address line 1 *']/following::input)[1]"));
//                element.sendKeys(value);
                break;
            case "city":
                element = driver.findElement(By.xpath("(//label[.='City *']/following::input[1])"));
//                element.sendKeys(value);
                break;
            case "zip code":
                element = driver.findElement(By.xpath("(//label[.='Zip code *']/following::input)[1]"));
                break;
            case "phone number":
                element = driver.findElement(By.xpath("(//label[.='Phone number *']/following-sibling::input)[2]"));
                break;
        }
        element.sendKeys(value);
    }


}


