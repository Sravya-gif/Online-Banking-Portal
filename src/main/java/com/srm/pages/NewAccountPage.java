package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class NewAccountPage extends BasePage {

    By newAccount = By.linkText("New Account");
    By custId = By.name("cusid");
    By deposit = By.name("inideposit");
    By submit = By.name("button2");

    By accountIdText = By.xpath("//td[text()='Account ID']/following-sibling::td");

    By editAccount = By.linkText("Edit Account");
    By accIdField = By.name("accountno");
    By editSubmit = By.name("AccSubmit");

    public NewAccountPage(WebDriver driver) {
        super(driver);
    }

    public void createAccount(String id, String amount) {

        waitForElement(newAccount).click();

        waitForElement(custId).sendKeys(id);
        driver.findElement(deposit).sendKeys(amount);

        driver.findElement(submit).click();
    }

    public String getAccountId() {
        waitForElement(accountIdText);
        return driver.findElement(accountIdText).getText();
    }

    public void editAccount(String accId) {

        waitForElement(editAccount).click();

        waitForElement(accIdField).sendKeys(accId);
        driver.findElement(editSubmit).click();

        if (driver.getTitle().contains("This page isn’t working") ||
            driver.getPageSource().contains("HTTP ERROR 500")) {

            System.out.println("Edit Account failed due to HTTP 500 error");
        }

        WebElement dep = waitForElement(deposit);
        dep.clear();
        dep.sendKeys("7000");

        driver.findElement(editSubmit).click();
    }
}