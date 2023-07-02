package com.loop.pages.smartBear;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearBasePage {
    public SmartBearBasePage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy(xpath = "//a[.='View all orders']")
    public WebElement viewAllOrdersLink;

    @FindBy(xpath = "//a[.='View all product']")
    public WebElement viewAllProductLink;

    @FindBy(xpath = "//a[.='Order']")
    public WebElement orderLink;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement logoutLink;

    @FindBy(xpath = "//a[.='Logout']")
    public WebElement webOrdersLink;

    @FindBy(xpath = "//h1[contains(text(),'Web Orders')]")
    public WebElement webOrders;



}
