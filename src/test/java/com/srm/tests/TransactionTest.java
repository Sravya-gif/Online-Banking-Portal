package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class TransactionTest extends BaseTest {

    @Test
    public void depositWithdrawTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("mngr659019", "hEpevyn");

        NewCustomerPage cp = new NewCustomerPage(driver);
        cp.createCustomer("Sravya");

        String custId = cp.getCustomerId();

        NewAccountPage ap = new NewAccountPage(driver);
        ap.createAccount(custId, "5000");

        String accId = ap.getAccountId();

        TransactionPage tp = new TransactionPage(driver);

        tp.deposit(accId);
        tp.withdraw(accId);

        Assert.assertTrue(true);
    }
}