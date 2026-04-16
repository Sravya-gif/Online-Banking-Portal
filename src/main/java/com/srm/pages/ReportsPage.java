package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class ReportsPage extends BasePage {

    By balance = By.linkText("Balance Enquiry");
    By mini = By.linkText("Mini Statement");
    By acc = By.name("accountno");
    By submit = By.name("AccSubmit");

    public ReportsPage(WebDriver driver) {
        super(driver);
    }

    public void checkBalance(String accountNo) {

        waitForElement(balance).click();

        waitForElement(acc).sendKeys(accountNo);
        driver.findElement(submit).click();

    }
    

    public void miniStatement(String accountNo) {

        waitForElement(mini).click();

        waitForElement(acc).sendKeys(accountNo);
        driver.findElement(submit).click();
        

    }
}