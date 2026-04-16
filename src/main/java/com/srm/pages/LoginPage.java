package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class LoginPage extends BasePage {

    By user = By.name("uid");
    By pass = By.name("password");
    By loginBtn = By.name("btnLogin");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void login(String username, String password) {

        waitForElement(user).sendKeys(username);
        waitForElement(pass).sendKeys(password);
        waitForElement(loginBtn).click();
    }
}