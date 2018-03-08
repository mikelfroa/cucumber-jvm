package com.mutua.test.testhooks;

import com.mutua.test.pageobjects.BasePage;
import com.mutua.test.pageobjects.page.SegDecPage;
import com.mutua.test.utility.Navigation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook()  {
        BasePage.getBrowser(System.getProperty("browser"));

    }

    @Before("@IrPaginaCotizacion")
    public void irPagCotizacion()  {
        Navigation.goToPage("PaginaCotizacion");
        SegDecPage decPage = new SegDecPage();
        decPage.calcularPrecio();

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario)  {
        if (scenario.isFailed()) {
            scenario.write("Current page " + BasePage.driver.getCurrentUrl());
        }
        BasePage.closeBrowser();

    }

}
