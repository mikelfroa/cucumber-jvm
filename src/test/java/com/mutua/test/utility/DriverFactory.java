package com.mutua.test.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    private static WebDriver driver;
    private static String browsername;
    private static String browserversion;
    private static String platform;
    private CargadorPropiedades cargador = new CargadorPropiedades();

    public DriverFactory() throws MalformedURLException {
        initialize();
    }

    public void initialize() throws MalformedURLException {
        if (driver == null)
            createNewDriverInstance();
    }

    private void createNewDriverInstance() throws MalformedURLException {
        String browserName = (System.getProperty("browser"));
        DesiredCapabilities capabilities;
        if (browserName == null ){
            browserName = "chrome";
        }
        switch (browserName) {
            case "firefox":
                if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()){
                    capabilities = DesiredCapabilities.firefox();
                    driver = new RemoteWebDriver(new URL(Constants.gridMachine), capabilities);
                    driver.manage().window().maximize();
                }else if (driver == null){
                    System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + cargador.cargarPropiedades().get("geckodriver")));
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                break;
            case "chrome":
                if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()){
                    capabilities = DesiredCapabilities.chrome();
                    driver = new RemoteWebDriver(new URL(Constants.gridMachine), capabilities);
                    driver.manage().window().maximize();
                }else {
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + cargador.cargarPropiedades().get("chromedriver")));
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                }
                break;
            case "edge":
                if (System.getProperty("grid") != null && !System.getProperty("grid").isEmpty()){
                    capabilities = DesiredCapabilities.edge();
                    driver = new RemoteWebDriver(new URL(Constants.gridMachine), capabilities);
                    driver.manage().window().maximize();
                }else {
                    System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + cargador.cargarPropiedades().get("edgedriver")));
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }
                break;
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void destroyDriver() {
        driver.quit();
        driver = null;
    }
}