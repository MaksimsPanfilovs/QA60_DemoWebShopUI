package com.demowebshop.fw;

import com.demowebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class UserHelper extends BaseHelper {

    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void clickOnLogOutButton() {
        click(By.cssSelector("[href='/logout']"));
    }

    public boolean isLogInLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/login']"));
    }


    public boolean isLogOutLinkPresent() {
        return isElementPresent(By.cssSelector("[href='/logout']"));
    }


    public boolean isUserAdded(String email) {
        List<WebElement> users = driver.findElements(By.linkText("Sfischer@gmail.com"));
        for (WebElement element : users) {
            if (element.getText().contains(email)) {
                return true;
            }
        }
        return false;
    }

    public void clickOnConfirmButton() {
        click(By.cssSelector("input[value='Continue']"));
    }

    public void clickOnRegistrationButton() {
        click(By.cssSelector("input#register-button"));
    }

    public void fillRegistrationForm(User user) {
        chooseYourGender(user.getGender());
        type(By.cssSelector("input#FirstName"), user.getFirstname());
        type(By.cssSelector("input#LastName"), user.getLastname());
        type(By.cssSelector("input#Email"), user.getEmail());
        type(By.cssSelector("input#Password"), user.getPassword());
        type(By.cssSelector("input#ConfirmPassword"), user.getPassword());
    }

    public void fillLoginForm(User user) {
        type(By.cssSelector("input#Email"), user.getEmail());
        type(By.cssSelector("input#Password"), user.getPassword());
    }

    public void clickOnRegistrationLink() {
        click(By.cssSelector("[href='/register']"));

    }

    public boolean isRegistrationErrorMessagePresent() {
        return isElementPresent(By.xpath("//li[.='The specified email already exists']"));
    }

    public void chooseYourGender(String gender) {
        if (gender == "male") {
            click(By.cssSelector("input#gender-male"));
        } else if (gender == "female") {
            click(By.cssSelector("input#gender-female"));
        }
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("[href='/login']"));
    }

    public void clickOnLoginButton() {
        click(By.cssSelector("input[value='Log in']"));
    }

    public boolean isLogErrorMessagePresent() {
        return isElementPresent(By.xpath("//span[contains(.,'unsuccessful')]"));
    }
}
