package com.srm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.srm.base.BaseTest;
import com.srm.pages.*;

public class FundTransferTest extends BaseTest {

    @Test
    public void fundTransferTest() {

        LoginPage lp = new LoginPage(driver);
        lp.login("mngr659019", "hEpevyn");

        NewCustomerPage cp = new NewCustomerPage(driver);
        cp.createCustomer("Sravya");

        String custId = cp.getCustomerId();

        NewAccountPage ap = new NewAccountPage(driver);
        ap.createAccount(custId, "5000");
        String acc1 = ap.getAccountId();
        System.out.println("Account 1: " + acc1);

        ap.createAccount(custId, "3000");
        String acc2 = ap.getAccountId();
        System.out.println("Account 2: " + acc2);

        FundTransferPage fp = new FundTransferPage(driver);
        fp.transfer(acc1, acc2, "1000");

        Assert.assertTrue(fp.isTransferSuccessful(),
                "Fund transfer failed");
    }
}