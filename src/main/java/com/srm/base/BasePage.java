package com.srm.base;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.*;

import java.time.Duration;

public class BasePage {

	protected WebDriver driver;
    Wait<WebDriver> wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;

        wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
    }

    public WebElement waitForElement(By locator) {
        return wait.until(driver -> driver.findElement(locator));
    }
}