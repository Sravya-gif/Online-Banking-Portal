package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class FundTransferPage extends BasePage {

    By fundTransfer = By.linkText("Fund Transfer");
    By payer = By.name("payersaccount");
    By payee = By.name("payeeaccount");
    By amount = By.name("ammount");
    By desc = By.name("desc");
    By submit = By.name("AccSubmit");
    
    By successMsg = By.xpath("//p[contains(text(),'Fund Transfer Details') or contains(text(),'Transfer')]");

    public boolean isTransferSuccessful() {
        try {
            waitForElement(successMsg);
            return driver.findElement(successMsg).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    public void transfer(String from, String to, String amt) {

        waitForElement(fundTransfer).click();

        waitForElement(payer).sendKeys(from);
        driver.findElement(payee).sendKeys(to);
        driver.findElement(amount).sendKeys(amt);
        driver.findElement(desc).sendKeys("Test Transfer");

        driver.findElement(submit).click();
    }
}