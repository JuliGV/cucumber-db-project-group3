package com.loop.pages.smartBear;

import com.loop.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.InputMismatchException;
import java.util.List;

public class ViewAllOrderPage {
    public ViewAllOrderPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy(xpath = "//tr//tr[2]/td//following-sibling::td")
    public List<WebElement> valueOfFirstRow;
}
