package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.srm.base.BaseTest;
import com.srm.pages.LoginPage;
import com.srm.utils.ExcelUtil;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] getData() {
        return ExcelUtil.getData("LoginData.xlsx", "Sheet1");
    }

    @Test(dataProvider = "loginData")
    public void testLogin(String username, String password) {

        LoginPage lp = new LoginPage(driver);
        lp.login(username, password);

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();

            Assert.fail("Invalid login");

        } catch (Exception e) {

            By managerId = By.xpath("//td[contains(text(),'Manger Id')]");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.visibilityOfElementLocated(managerId));

            boolean isDisplayed = driver.findElement(managerId).isDisplayed();

            Assert.assertTrue(isDisplayed, "Valid login failed");
        }
    }
}