package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if(!app.getUser().isLogInLinkPresent()){
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void userLoginPositiveTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isUserAdded(UserData.EMAIL));

    }

    @Test
    public void userLoginNegativeTest() {
        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();

        Assert.assertTrue(app.getUser().isLogErrorMessagePresent());

    }


}
