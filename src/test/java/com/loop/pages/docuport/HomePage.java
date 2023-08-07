package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public HomePage(){

        PageFactory.initElements(Driver.driver(),this);
    }

    public static final String CHOOSEACCOUNT = "//h3[.='Choose account']";


    @FindBy(xpath = "//span[.='Batch1 Group3']")
    public WebElement userMenuBtn;

    @FindBy (xpath = "//span[.='Profile']")
    public WebElement profileOption;

    @FindBy(xpath = "//div[.='Email address']//following-sibling::div/span")
    public WebElement emailAddressValue;

    @FindBy (xpath = "//i[@class='v-icon notranslate mdi mdi-home theme--light']")
    public WebElement homeIcone;

    @FindBy(xpath = "//input[@type='text']/..")
    public WebElement accountDropdown;

    @FindBy(xpath = "//h3[.='Choose account']")
    public WebElement dropdownTextIsDisplayed;

    /**
     * choose account from dropdown
     * @param name
     * @author Yuliia
     */
    public void chooseAccountFromDropdpwn(String name){
        Driver.driver().findElement(By.xpath("//span[.=' "+name+" ']/..")).click();
    }

    @FindBy(xpath = "//span[.=' Continue ']/..")
    public WebElement continueBtn;

}
