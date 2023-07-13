package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyUploadsPage {
    public MyUploadsPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy(xpath = "//h1[.='My uploads']/..")
    public WebElement myUploadsHeader;


    /**
     * check if Download,Search,Delete and Upload documents btns are displayed
     * @param nameOfBtn
     * @return
     */
    public void checkIfDisplayedBtn(String nameOfBtn){
        Assert.assertTrue(nameOfBtn+" button doesn't dispaleyed",Driver.driver().findElement(By.xpath("//span[.='"+nameOfBtn+"']/..")).isDisplayed());
    }
}
