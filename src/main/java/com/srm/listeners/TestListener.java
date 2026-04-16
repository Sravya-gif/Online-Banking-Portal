package com.srm.listeners;

import org.testng.*;
import com.aventstack.extentreports.*;

import com.srm.base.BaseTest;
import com.srm.utils.*;

public class TestListener implements ITestListener {
    ExtentReports extent = ExtentManager.getReport();
    ThreadLocal<ExtentTest> test = new ThreadLocal<>();

    @Override
    public void onTestStart(ITestResult result) {
        ExtentTest extentTest = extent.createTest(result.getName());
        test.set(extentTest);

        System.out.println("STARTING: " + result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.get().pass("Test Passed");
        System.out.println("PASSED: " + result.getName());
    }

    @Override
    public void onTestFailure(ITestResult result) {

        System.out.println("FAILED: " + result.getName());

        if (BaseTest.driver == null) {
           
            return;
        }

        String path = ScreenshotUtil.capture(BaseTest.driver, result.getName());

        if (!path.isEmpty()) {
            try {
                test.get().addScreenCaptureFromPath(path);
               
            } catch (Exception e) {
                
            }
        } else {
            System.out.println("Screenshot path empty");
        }
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
       
    }
}