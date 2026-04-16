package com.srm.pages;

import org.openqa.selenium.*;
import com.srm.base.BasePage;

public class NewCustomerPage extends BasePage {

    By newCustomer = By.linkText("New Customer");
    By name = By.name("name");
    By gender = By.xpath("//input[@value='f']");
    By dob = By.name("dob");
    By address = By.name("addr");
    By city = By.name("city");
    By state = By.name("state");
    By pin = By.name("pinno");
    By mobile = By.name("telephoneno");
    By email = By.name("emailid");
    By password = By.name("password");
    By submit = By.name("sub");

    By customerIdText = By.xpath("//td[text()='Customer ID']/following-sibling::td");

    By editCustomer = By.linkText("Edit Customer");
    By deleteCustomer = By.linkText("Delete Customer");
    By custIdField = By.name("cusid");
    By submitBtn = By.name("AccSubmit");

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    public void createCustomer(String custName) {

        waitForElement(newCustomer).click();

        waitForElement(name).sendKeys(custName);
        driver.findElement(gender).click();
        driver.findElement(dob).sendKeys("11032005");
        driver.findElement(address).sendKeys("Guntur");
        driver.findElement(city).sendKeys("Guntur");
        driver.findElement(state).sendKeys("AP");
        driver.findElement(pin).sendKeys("522034");
        driver.findElement(mobile).sendKeys("9876543210");
        driver.findElement(email)
                .sendKeys("test" + System.currentTimeMillis() + "@mail.com");
        driver.findElement(password).sendKeys("test123");

        driver.findElement(submit).click();
    }

    public String getCustomerId() {
        waitForElement(customerIdText);
        return driver.findElement(customerIdText).getText();
    }

    public void editCustomer(String custId) {

        waitForElement(editCustomer).click();

        waitForElement(custIdField).sendKeys(custId);
        driver.findElement(submitBtn).click();

        WebElement addr = waitForElement(address);
        addr.clear();
        addr.sendKeys("Updated Address");

        driver.findElement(submitBtn).click();
    }

    public void deleteCustomer(String custId) {

        waitForElement(deleteCustomer).click();

        waitForElement(custIdField).sendKeys(custId);
        driver.findElement(submitBtn).click();

        try {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            alert = driver.switchTo().alert();
            alert.accept();
        } catch (Exception e) {
           
        }
    }
}