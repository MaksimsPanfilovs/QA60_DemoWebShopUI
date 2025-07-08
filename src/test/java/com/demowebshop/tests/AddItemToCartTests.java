package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddItemToCartTests extends TestBase {

    @BeforeMethod
    public void precondition() {
        if (!app.getUser().isLogInLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }

        app.getUser().clickOnLoginLink();
        app.getUser().fillLoginForm(new User().setEmail(UserData.EMAIL)
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addItemToCartPositiveTest() {
        app.getProduct().clickOnAddToCartButton();
        app.getProduct().clickOnCartLink();
        Assert.assertTrue(app.getProduct().isProductPresentInCart());
    }


    @AfterMethod
    public void postRCondition() {
        app.getProduct().removeProductFromCart();
    }
}
