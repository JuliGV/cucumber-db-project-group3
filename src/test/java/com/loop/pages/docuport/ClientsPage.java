package com.loop.pages.docuport;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
    public ClientsPage() {
        PageFactory.initElements(Driver.driver(), this);
    }

    @FindBy(xpath = "//span[.='Create new client']/..")
    public WebElement createNewClientBtn;

//    @FindBy (xpath = "//span[.='Personal']/..")
//    public WebElement

    public void clickTypeOfClient(String option) {

        Driver.driver().findElement(By.xpath("//span[.='" + option + "']/..")).click();
    }

    @FindBy(xpath = "//label[.='Owner']/..")
    public WebElement ownerDropdown;

    @FindBy(xpath = "//input[@placeholder='Please enter 3 or more characters']")
    public WebElement ownerSendKeys;

    @FindBy(xpath = "(//span[.='Test Test']/..)[2]")
    public WebElement testTestUser;

    @FindBy(xpath = "//span[contains(.,'Save')]/..")
    public WebElement saveBtn;

    public void clickOnEditBtn(String clientFullName) {
        Driver.driver().findElement(By.xpath("//span[.='" + clientFullName + "']/../..//following-sibling::td[6]//div//button")).click();
    }

    public String returnValueOfRowTable(String fullName, String column) {
        String rowValue = "";

        switch (column.toLowerCase()) {
            case "phone number":
                 rowValue = Driver.driver().findElement(By.xpath("(//span[.='" + fullName + "']/../..//following-sibling::td)[1]")).getText();
            break;
            case "email":
                rowValue =  Driver.driver().findElement(By.xpath("(//span[.='" + fullName + "']/../..//following-sibling::td)[2]")).getText();
            break;
            case "owner":
                rowValue =  Driver.driver().findElement(By.xpath("(//span[.='" + fullName + "']/../..//following-sibling::td)[3]")).getText();
            break;
            case "advisor":
                rowValue =  Driver.driver().findElement(By.xpath("(//span[.='" + fullName + "']/../..//following-sibling::td)[4]")).getText();
            break;
            case "services":
                rowValue =  Driver.driver().findElement(By.xpath("(//span[.='" + fullName + "']/../..//following-sibling::td)[5]")).getText();
            break;

        }
        return rowValue;
    }

    @FindBy(xpath = "//label[.='Email address']//following-sibling::input")
    public WebElement emailOfClient;

    @FindBy(xpath = "//span[contains(.,'Save')]/..")
    public WebElement saveBtnEditClient;

    public void clickAndSelectFromAdvisorDrop(String option){
        Driver.driver().findElement(By.xpath("//label[.='Advisor']/..")).click();
        Driver.driver().findElement(By.xpath("//div[.='"+option+"']")).click();
    }
    @FindBy(xpath = "//div[.='Batch1 Group3']")
    public WebElement advisorDropdown;

    @FindBy(xpath = "//label[.='Advisor']/..")
    public WebElement advisorDrop;

    public void clickAndSelectFromServicesDrop(String option){
        Driver.driver().findElement(By.xpath("//label[.='Advisor']/..")).click();
        Driver.driver().findElement(By.xpath("(//div[.='"+option+"']/..)[2]//div")).click();
    }

    @FindBy(xpath = "(//div[.='Tax']/..)[2]//div")
    public WebElement servicesTax;

    @FindBy(xpath = "//label[.='Services']/..")
    public WebElement servicesDrop;

    public void choseRowPerPage(String number){

    }


}
