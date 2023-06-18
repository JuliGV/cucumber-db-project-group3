package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.InputMismatchException;

public class DocuportWebTableUtils {

    public static String returnAnyFieldUserTable(WebDriver driver, String email, String field){
        WebElement element = null;
        String xpath = "";

        switch(field.toLowerCase()){
            case "full name":
                xpath = "//td[2][.='" + email + "']/preceding-sibling::td//span[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "username":
                xpath = "//td[2][.='" + email + "']/following-sibling::td[1]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "inviter":
                xpath = "//td[2][text()='"+email+"']/following-sibling::td[2]";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "phone number":
                xpath = "//td[2][text()='"+email+"']/following-sibling::td[3]/span";
                element = driver.findElement(By.xpath(xpath));
                break;
            case "role":
                xpath = "//td[2][text()='"+email+"']/following-sibling::td[4]/span/span";
                element = driver.findElement(By.xpath(xpath));
                break;
            default: throw new InputMismatchException("Field is not correct");

        }
        return element.getText();
    }

    public static String LeadsTableAnyField(WebDriver driver,String email,String field){

        WebElement element = null;

        switch(field.toLowerCase()){
            case "phone number":
                element = driver.findElement(By.xpath("//td[.='"+email+"']/following::td[1]"));
                break;
            case "full name" :
                element = driver.findElement(By.xpath("//td[.='"+email+"']/preceding::td[1]"));
                break;
            case"status":
                element = driver.findElement(By.xpath("//td[.='"+email+"']/following::td[3]"));
                break;
            default:
                System.out.println("No such field expected");

        }

        return  element.getText();
    }
}
