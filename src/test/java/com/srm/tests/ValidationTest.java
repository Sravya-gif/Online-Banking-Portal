package com.srm.tests;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;

public class ValidationTest extends BaseTest {

    @Test
    public void invalidLoginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("wrong", "wrong");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String msg = alert.getText();
            System.out.println("Invalid Alert: " + msg);

            alert.accept();

            Assert.fail("Invalid login should fail");

        } catch (Exception e) {
            Assert.fail("Alert not displayed for invalid login");
        }
    }

    @Test
    public void blankLoginTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("", "");

        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());

            String msg = alert.getText();
            System.out.println("Blank Alert: " + msg);

            alert.accept();

            Assert.fail("Blank login should fail");

        } catch (Exception e) {
            Assert.fail("Alert not displayed for blank login");
        }
    }
}