package com.loop.pages.google;

import com.loop.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WikipediaSearchPage {
    public WikipediaSearchPage(){
        PageFactory.initElements(Driver.driver(),this);
    }

    @FindBy (xpath = "//label[.='Search Wikipedia']//following-sibling::input")
    public WebElement searchBox;

    @FindBy (xpath  ="//i[.='Search']/..")
    public WebElement searchBtn;

    @FindBy (xpath = "//h1[@id='firstHeading']/span")
    public WebElement header;

    @FindBy(xpath = "//th[@class='infobox-above']/div")
    public WebElement imageHeader;

}
