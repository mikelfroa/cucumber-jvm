package com.mutua.test.stepdefinitions;

import com.mutua.test.utility.DriverFactory;
import com.mutua.test.utility.GeneralUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class HomeStepDef {

    private WebDriver driver;

    @Given("^estoy en la pagina de login$")
    public void estoyEnLaPaginaDeLogin() throws Throwable {
        driver = new DriverFactory().getDriver();
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("I am at the home page", driver.getCurrentUrl().equalsIgnoreCase("https://www.mutua.es/"));

    }
}
