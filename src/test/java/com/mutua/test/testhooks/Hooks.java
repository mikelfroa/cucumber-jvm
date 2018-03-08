package com.mutua.test.testhooks;

import com.mutua.test.pageobjects.BasePage;
import com.mutua.test.pageobjects.page.SegDecPage;
import com.mutua.test.utility.Navigation;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.TakesScreenshot;

import static org.openqa.selenium.OutputType.BYTES;

public class Hooks {

    @Before(order = 1, value = "@SetupDriver")
    public void setupUp()  {
        BasePage.getBrowser(System.getProperty("browser"));

    }

    @Before("@IrPaginaCotizacion")
    public void irPagCotizacion()  {
        Navigation.goToPage("PaginaCotizacion");
        SegDecPage decPage = new SegDecPage();
        decPage.calcularPrecio();

    }

    @After("@SetupDriver")
    public void tearDown(Scenario scenario)  {
        if (scenario.isFailed()) {
            scenario.write("Current page " + BasePage.driver.getCurrentUrl());
            if (BasePage.driver instanceof TakesScreenshot) {
                TakesScreenshot camera = (TakesScreenshot) BasePage.driver;
                byte[] screenshot = camera.getScreenshotAs(BYTES);
                scenario.embed(screenshot, "image/png");
            }

        }
        BasePage.closeBrowser();

    }

}
