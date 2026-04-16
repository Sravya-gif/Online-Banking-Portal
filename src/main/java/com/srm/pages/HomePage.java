package com.srm.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import com.srm.base.BasePage;

public class HomePage extends BasePage {

    By logout = By.xpath("//a[contains(text(),'Log out')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void logout() {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement logoutBtn = wait.until(
                ExpectedConditions.presenceOfElementLocated(logout));

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].scrollIntoView(true);", logoutBtn);

        ((JavascriptExecutor) driver)
                .executeScript("arguments[0].click();", logoutBtn);

        try {
            Alert alert = wait.until(ExpectedConditions.alertIsPresent());
            alert.accept();
        } catch (Exception e) {
           
        }
    }
}