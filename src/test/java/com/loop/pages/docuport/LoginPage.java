package com.loop.pages.docuport;

import com.loop.utilities.BrowsersUtility;
import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy(xpath = "//label[.='Username or email']//following-sibling::input")
    public WebElement usernameBox;

    @FindBy(xpath = "//label[.='Password']//following-sibling::input")
    public WebElement passwordBox;

    @FindBy (xpath = "//span[text()=' Log in ']/..")
    public WebElement loginBtn;

    /**
     * login to docuport
     * @param userName
     * @param password
     * @author Yuliia
     */
    public void loginDocuport(String userName,String password){
        BrowsersUtility.waitForVisibility(usernameBox,5);
        usernameBox.clear();
        usernameBox.sendKeys(userName);
        passwordBox.clear();
        passwordBox.sendKeys(password);
        BrowsersUtility.waitForClickable(loginBtn,5);
        BrowsersUtility.clickWithJS(loginBtn);
    }




}
