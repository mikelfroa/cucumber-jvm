package com.mutua.test.stepdefinitions;

import com.mutua.test.pageobjects.BasePage;
import com.mutua.test.utility.GeneralUtils;
import cucumber.api.java.en.Given;
import org.junit.Assert;

public class HomeStepDef extends BasePage {

    @Given("^I am at the home page$")
    public void iAmAlTheLoginPage() throws Throwable {
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("I am at the home page", driver.getCurrentUrl().equalsIgnoreCase("https://www.mutua.es/"));
    }

}
