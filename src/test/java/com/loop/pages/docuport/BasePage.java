package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.stream.Collectors;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.driver(),this);
    }
    public void clickMenuLink(String link){
        Driver.driver().findElement(By.xpath("//span[.='"+link+"']")).click();
    }

//    public List<String> getTextMenuLinks(List<WebElement> elements){
//        return elements.stream()
//                .map(WebElement::getText)
//                .collect(Collectors.toList());
//    }

    public String getTextMenuLinks(String link){
        return Driver.driver().findElement(By.xpath("//span[.='"+link+"']")).getText();

    }
}
