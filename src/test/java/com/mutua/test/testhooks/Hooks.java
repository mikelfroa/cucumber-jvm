package com.mutua.test.testhooks;

import com.mutua.test.utility.CargadorPropiedades;
import com.mutua.test.utility.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;

public class Hooks {

    private WebDriver driver;
    private CargadorPropiedades cargador = new CargadorPropiedades();

    @Before(order = 1, value = "@SetupDriver")
    public void setupSeleniumConnectionHook() throws Exception {
        driver = new DriverFactory().getDriver();
    }

    @Before("@GoHomePage")
    public void goLoginPage() throws MalformedURLException {
        driver = new DriverFactory().getDriver();
        driver.get((String)cargador.cargarPropiedades().get("urlCotizacion"));

    }

    @After("@SetupDriver")
    public void tearDownSeleniumConnectionHook(Scenario scenario) throws MalformedURLException {
        if (scenario.isFailed()) {
            driver = new DriverFactory().getDriver();
            scenario.write("Current page " + driver.getCurrentUrl());
        }
        new DriverFactory().destroyDriver();

    }

}
