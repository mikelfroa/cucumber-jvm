package com.mutua.test.testhooks;

import com.mutua.test.pageobjects.BasePage;
import com.mutua.test.utility.BrowserFactory;
import com.mutua.test.utility.Navigation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook() throws Exception {
        BrowserFactory.getBrowser(System.getProperty("browser"));

    }

    @Before("@GoHomePage")
    public void goLoginPage()  {
        Navigation.goToPage("HomePage");

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario)  {
        if (scenario.isFailed()) {
            scenario.write("Current page " + BasePage.driver.getCurrentUrl());
        }
        BrowserFactory.closeBrowser();

    }

}
