package com.loop.pages.smartBear;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SmartBearOrderPage extends SmartBearBasePage{
    public SmartBearOrderPage(){
        PageFactory.initElements(Driver.driver(),this);
    }
    @FindBy(xpath = "")
    public WebElement sample;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_ddlProduct']")
    public WebElement product;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtQuantity']")
    public WebElement quantity;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtUnitPrice']")
    public WebElement pricePerUnit;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtDiscount']")
    public WebElement discount;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtTotal']")
    public WebElement total;

    @FindBy(xpath = "//input[@type='submit']")
    public WebElement calculateBtn;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_txtName']")
    public WebElement customerName;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox2']")
    public WebElement street;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox3']")
    public WebElement city;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox4']")
    public WebElement state;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox5']")
    public WebElement zip;

    @FindBy(xpath = "//input[@type='radio']")
    public List<WebElement> cardType;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox6']")
    public WebElement cardNum;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_TextBox1']")
    public WebElement expDate;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_fmwOrder_InsertButton']")
    public WebElement processBtn;

    @FindBy(xpath = "//input[@type='reset']")
    public WebElement resetBtn;

    @FindBy(xpath = "//h2[contains(.,'Order')]")
    public WebElement orderHeader;

    
    
}
