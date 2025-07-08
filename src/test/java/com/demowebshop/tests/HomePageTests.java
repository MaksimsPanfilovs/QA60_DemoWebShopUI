package com.demowebshop.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getHome().isHomePagePresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void isHomePageElementPresent() {
        Assert.assertTrue(app.getHome().isHomePagePresent());
    }
}
