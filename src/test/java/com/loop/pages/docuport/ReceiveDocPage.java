package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ReceiveDocPage {
    public ReceiveDocPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    /**
     * check if Download,Search and Change status btns are displayed
     * @param nameOfBtn
     * @return
     */
    public void checkIfDisplayedBtn(String nameOfBtn){
       Assert.assertTrue(nameOfBtn+" button doesn't dispaleyed",Driver.driver().findElement(By.xpath("//span[.='"+nameOfBtn+"']/..")).isDisplayed());
    }

//    @FindBy(xpath = "//span[.='Download']/..")
//    public WebElement downloadBtn;
//
//    @FindBy(xpath = "//span[.='Search']/..")
//    public WebElement searchBtn;

@FindBy(xpath = "//h1[.='Received docs']/..")
    public WebElement receivedDocHeader;


}
