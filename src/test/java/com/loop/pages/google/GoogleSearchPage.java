package com.loop.pages.google;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GoogleSearchPage {
    public GoogleSearchPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy(id = "APjFqb")
    public WebElement searchBox;

    @FindBy(xpath = "//input[@id='gbqfbb']/preceding-sibling::input")
    public WebElement googleSearchBTN;

    @FindBy(xpath="//a[@class='FLP8od']")
    public WebElement capital;


}
