package com.demowebshop.tests;

import com.demowebshop.data.UserData;
import com.demowebshop.models.User;
import com.demowebshop.utils.DataProviders;
import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreateAccountTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!app.getUser().isLogInLinkPresent()) {
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void newUserRegistrationPositiveTest() {
        int i = (int) ((System.currentTimeMillis() / 1000) % 3600);

        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setGender(UserData.GENDER)
                .setFirstname(UserData.FIRSTNAME)
                .setLastname(UserData.LASTNAME)
                .setEmail("Sfischer" + i + "@gmail.com")
                .setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();
        app.getUser().clickOnConfirmButton();

        Assert.assertTrue(app.getUser().isLogOutLinkPresent());
    }



    @Test(dataProvider = "addNewUser", dataProviderClass = DataProviders.class)
    public void addNewUserFromDataProviderTest(String gender, String firstname,
                                               String lastname, String email,
                                               String password) {

        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User()
                .setGender(gender)
                .setFirstname(firstname)
                .setLastname(lastname)
                .setEmail(email)
                .setPassword(password));
        app.getUser().pause(300);
        app.getUser().clickOnRegistrationButton();
        if (app.getUser().isRegistrationErrorMessagePresent()) {
            Assert.assertTrue(app.getUser().isRegistrationErrorMessagePresent());
            app.getUser().clickOnRegistrationLink();
        } else {
            app.getUser().clickOnConfirmButton();
            Assert.assertTrue(app.getUser().isLogOutLinkPresent());
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test(dataProvider = "addNewContactWithCsv", dataProviderClass = DataProviders.class)
    public void addNewUserFromDataProviderWithCsvFileTest(User user) {

        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(user);
        app.getUser().clickOnRegistrationButton();
        if (app.getUser().isRegistrationErrorMessagePresent()) {
            Assert.assertTrue(app.getUser().isRegistrationErrorMessagePresent());
            app.getUser().clickOnRegistrationLink();
        } else {
            app.getUser().clickOnConfirmButton();
            Assert.assertTrue(app.getUser().isLogOutLinkPresent());
            app.getUser().clickOnLogOutButton();
        }
    }

    @Test
    public void newUserRegistrationNegativeTest() {
        app.getUser().clickOnRegistrationLink();
        app.getUser().fillRegistrationForm(new User().setGender(UserData.GENDER)
                .setFirstname(UserData.FIRSTNAME).setLastname(UserData.LASTNAME)
                .setEmail(UserData.EMAIL).setPassword(UserData.PASSWORD));
        app.getUser().clickOnRegistrationButton();

        Assert.assertTrue(app.getUser().isRegistrationErrorMessagePresent());
    }


}
