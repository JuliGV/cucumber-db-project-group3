package com.loop.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PizzaCheckbox {
    public static void DeselectAndDeselectByName(WebDriver driver, String name) {
//        List<WebElement> checkboxes  = driver.findElements(By.xpath("//input[@type='checkbox']"));
        //List<WebElement> names = driver.findElements(By.xpath("//input[@type='checkbox']/following::td[1]"));

        WebElement element = driver.findElement(By.xpath("//td[.='" + name + "']/preceding::td[1]/input"));
        element.click();

        if (element.isSelected()) {
            System.out.println("Element was selected");
            element.click();
        } else {
            System.out.println("Checkbox was not selected");
        }
        if (!element.isSelected()) {
            System.out.println("Element was deselected");
        } else {
            System.out.println("Checkbox was not selected");
        }

    }
}
