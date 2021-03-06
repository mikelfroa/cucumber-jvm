package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GeneralUtils extends BasePage {

    public static void waitForPageLoaded() throws InterruptedException {
        Thread.sleep(2000);
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString().equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(BasePage.driver, 30);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

}
