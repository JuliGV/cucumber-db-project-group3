package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.driver(),this);
    }


    @FindBy(xpath = "//span[.='Batch1 Group3']/../../..")
    public WebElement userMenuBtn;

    @FindBy (xpath = "//span[.='Profile']/..")
    public WebElement profileOption;

    @FindBy(xpath = "//div[.='Email address']//following-sibling::div/span")
    public WebElement emailAddressValue;

    @FindBy (xpath = "//i[contains(@class,'mdi-home theme--light')]")
    public WebElement homeIcone;
}
