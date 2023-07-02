package com.loop.pages.smartBear;

import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SmartBearLoginPage extends SmartBearBasePage{
    public SmartBearLoginPage(){
        PageFactory.initElements(Driver.driver(),this);
    }
    @FindBy(xpath = "//*[@id='ctl00_MainContent_username']")
    public WebElement userNameBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_password']")
    public WebElement passwordBox;

    @FindBy(xpath = "//*[@id='ctl00_MainContent_login_button']")
    public WebElement loginBtn;

    public void login(String username,String password){
        BrowsersUtility.waitForVisibility(userNameBox,5);
        userNameBox.clear();
        userNameBox.sendKeys(username);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        BrowsersUtility.waitForClickable(loginBtn,5);
        BrowsersUtility.clickWithJS(loginBtn);
    }
    
}
