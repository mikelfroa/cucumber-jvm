package com.mutua.test.testhooks;

import com.mutua.test.pageobjects.BasePage;
import com.mutua.test.pageobjects.page.SegDecPage;
import com.mutua.test.utility.BrowserFactory;
import com.mutua.test.utility.Navigation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {

    private WebDriver driver;


    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook() throws Exception {
        BrowserFactory.getBrowser(System.getProperty("browser"));

    }

    @Before("@IrPaginaCotizacion")
    public void goLoginPage()  {
        Navigation.goToPage("PaginaCotizacion");
        SegDecPage decPage = new SegDecPage();
        decPage.calcularPrecio();

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario) throws MalformedURLException {
        if (scenario.isFailed()) {
            scenario.write("Current page " + BasePage.driver.getCurrentUrl());
        }
        BrowserFactory.closeBrowser();

    }

}
