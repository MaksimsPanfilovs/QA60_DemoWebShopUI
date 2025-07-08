package com.demowebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;


public class HomePageHelper extends BaseHelper {

    public HomePageHelper(WebDriver driver) {
        super(driver);
    }

    @Test
    public boolean isHomePagePresent() {
        return isElementPresent(By.linkText("Log in"));
    }
}
