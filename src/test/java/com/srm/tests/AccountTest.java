package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class AccountTest extends BaseTest {

    static String savedAccountId;

    @Test(priority = 1)
    public void createAccountTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("mngr659019", "hEpevyn");

        NewCustomerPage cp = new NewCustomerPage(driver);
        cp.createCustomer("Sravya");

        String custId = cp.getCustomerId();

        NewAccountPage ap = new NewAccountPage(driver);
        ap.createAccount(custId, "5000");

        savedAccountId = ap.getAccountId();

        System.out.println("Saved Account ID: " + savedAccountId);

        Assert.assertTrue(savedAccountId != null && !savedAccountId.isEmpty());
    }


    @Test(priority = 2)
    public void editAccountTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("mngr659019", "hEpevyn");

        NewAccountPage ap = new NewAccountPage(driver);

        System.out.println("Editing Account ID: " + savedAccountId);

        ap.editAccount(savedAccountId);

        boolean success = driver.getPageSource()
                .contains("Account details updated Successfully");

        Assert.assertTrue(success, "Edit account failed");
    }
}