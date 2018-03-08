package com.mutua.test.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
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
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                break;
            case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                break;
            case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
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