package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage() {
        PageFactory.initElements(Driver.driver(), this);
    }

    public void clickLeftMenuBtn(String link) {

        Driver.driver().findElement(By.xpath("//span[.='" + link + "']/..")).click();
    }

    @FindBy(xpath = "//span[.='Home']/..")
    public WebElement homeBtnLeftMenu;

    @FindBy(xpath = "//span[.='Received docs']/..")
    public WebElement receivedDocsBtnLeftMenu;

    @FindBy(xpath = "//span[.='My uploads']/..")
    public WebElement myUploadsBtnLeftMenu;

    @FindBy(xpath = "//span[.='Clients']/..")
    public WebElement clientsBtnLeftMenu;

    @FindBy(xpath = "//span[.='Upload']/..")
    public WebElement uploadBtnLeftMenu;

    @FindBy(xpath = "//span[.='Invitations']/..")
    public WebElement invitationsBtnLeftMenu;

    @FindBy(xpath = "//span[.='Users']/..")
    public WebElement usersBtnLeftMenu;
    @FindBy(xpath = "//span[.='Leads']/..")
    public WebElement leadsBtnLeftMenu;
    @FindBy(xpath = "//span[.='Bookkeeping']/..")
    public WebElement bookkeepingBtnLeftMenu;

    @FindBy(xpath = "//span[.='1099 Form']/..")
    public WebElement form1099BtnLeftMenu;

    @FindBy(xpath = "//span[.='Reconciliations']/..")
    public WebElement reconciliationsBtnLeftMenu;
    @FindBy(xpath = "//img[@alt='Docuport']/..")
    public WebElement docuportLabelLeftMenu;

    @FindBy(xpath = "//button[@class='v-app-bar__nav-icon v-btn v-btn--icon v-btn--round theme--light v-size--default']")
    public WebElement burger;
    @FindBy(xpath = "//span[.='Batch1 Group3']/..")
    public WebElement userButton;

    @FindBy (xpath = "//span[text()=' Log in ']/..")
    public WebElement loginBtn;
    @FindBy(xpath = "//span[.=' Continue ']/..")
    public WebElement continueBtn;


   @FindBy(xpath = "//h1[.='1099 Form']")
   public WebElement form1099;

    public String getTextMenuLinks(String link) {
        return Driver.driver().findElement(By.xpath("//span[.='" + link + "']")).getText();
    }

    public static void sendKeysToFirstOrLastName(String lastOrFirst, String name) {
        Driver.driver().findElement(By.xpath("//label[.='" + lastOrFirst + "']//following-sibling::input")).sendKeys(name);
    }

    /**
     * click on button
     *
     * @param nameBtn
     */
    public void clickOnButton(String nameBtn) {
        switch (nameBtn) {
            case "Received docs":
                receivedDocsBtnLeftMenu.click();
                break;
            case "My uploads":
                myUploadsBtnLeftMenu.click();
                break;
            case "Clients":
                clientsBtnLeftMenu.click();
                break;
            case "Home":
                homeBtnLeftMenu.click();
                break;
            case "Upload":
                uploadBtnLeftMenu.click();
                break;
            case "Invitations":
                invitationsBtnLeftMenu.click();
                break;
            case "Users":
                usersBtnLeftMenu.click();
                break;
            case "Leads":
                leadsBtnLeftMenu.click();
                break;
            case "Bookkeeping":
                bookkeepingBtnLeftMenu.click();
                break;
            case "1099 Form":
                form1099BtnLeftMenu.click();
                break;
            case "Reconciliations":
                reconciliationsBtnLeftMenu.click();
                break;
            case "Docuport":
                docuportLabelLeftMenu.click();
                break;
            case "Batch1 Group":
                userButton.click();
                break;
            case "Log in":
                loginBtn.click();
                break;
            case "Continue":
                continueBtn.click();
                break;

            
        }
    }



    @FindBy(xpath = "//input[@aria-label='Rows per page:']/preceding-sibling::div")
    public WebElement numberOfRowsByDefaul;

    @FindBy(xpath = "//div[@class='v-input__append-inner']")
    public WebElement rowPerPageDrop;

    public void chooseNumOfPage(Integer numberOfPage){
        rowPerPageDrop.click();
        WebElement numOfRows = Driver.driver().findElement(By.xpath("//div[@class='v-list-item__content' and div[.='"+numberOfPage+"']]"));
        numOfRows.click();
    }


}
