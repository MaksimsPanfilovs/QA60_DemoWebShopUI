package com.demowebshop.tests;

import com.demowebshop.fw.ApplicationManeger;
import org.openqa.selenium.remote.Browser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.util.Arrays;

public class TestBase {

    protected static ApplicationManeger app = new ApplicationManeger(
            System.getProperty("browser", Browser.CHROME.browserName()));

    Logger logger = LoggerFactory.getLogger(TestBase.class);

    @BeforeSuite
    public void setUp() {
        app.init();
    }

    @BeforeMethod
    public void startTest(Method method, Object[] p) {
        logger.info("Start test " + method.getName() + Arrays.asList(p));
    }

    @AfterMethod
    public void stopTest(ITestResult result) {
        if (result.isSuccess()) {
            logger.info("PASSED: " + result.getMethod().getMethodName());
        }else {
            logger.error("FAILED: " + result.getMethod()
                    .getMethodName() + "Screenshot path: " + app.getUser()
                    .takeScreenshot());
        }
        logger.info("Stop test");
        logger.info("===========================================");

    }

    @AfterSuite
    public void tearDown() {
        app.stop();
    }


}
