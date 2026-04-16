package com.srm.tests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class LogoutTest extends BaseTest {

	@Test
	public void logoutTest() {

	    LoginPage lp = new LoginPage(driver);
	    lp.login("mngr659019", "hEpevyn");

	    HomePage hp = new HomePage(driver);
	    hp.logout();

	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("uid")));

	    Assert.assertTrue(driver.findElement(By.name("uid")).isDisplayed(),
	            "Logout failed");
	}
}