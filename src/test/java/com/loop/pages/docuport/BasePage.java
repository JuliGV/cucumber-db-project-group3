package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    public void clickMenuLink(String link){

        Driver.driver().findElement(By.xpath("//span[.='"+link+"']/..")).click();
    }

    public String getTextMenuLinks(String link){
        return Driver.driver().findElement(By.xpath("//span[.='"+link+"']")).getText();
    }

    public static void sendKeysToFirstOrLastName(String lastOrFirst,String name){
         Driver.driver().findElement(By.xpath("//label[.='"+lastOrFirst+"']//following-sibling::input")).sendKeys(name);
    }





}
