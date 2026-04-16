package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class TransactionPage extends BasePage {

    By depositLink = By.linkText("Deposit");
    By withdrawLink = By.linkText("Withdrawal");

    By account = By.name("accountno");
    By amount = By.name("ammount");
    By desc = By.name("desc");
    By submit = By.name("AccSubmit");

    public TransactionPage(WebDriver driver) {
        super(driver);
    }

    public void deposit(String acc) {

        driver.findElement(depositLink).click();

        waitForElement(account).sendKeys(acc);
        driver.findElement(amount).sendKeys("500");
        driver.findElement(desc).sendKeys("deposit");

        driver.findElement(submit).click();
    }

    public void withdraw(String acc) {

        driver.findElement(withdrawLink).click();

        waitForElement(account).sendKeys(acc);
        driver.findElement(amount).sendKeys("200");
        driver.findElement(desc).sendKeys("withdraw");

        driver.findElement(submit).click();
    }
}