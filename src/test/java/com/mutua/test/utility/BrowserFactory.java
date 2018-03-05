package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class BrowserFactory extends BasePage {

    private static DesiredCapabilities capabilities;

    public static void getBrowser(String browserName) throws MalformedURLException {
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
                    System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe"));
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
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe"));
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
                    System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + "/src/test/resources/MicrosoftWebDriver.exe"));
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                }
                break;
        }

    }

    public static void closeBrowser(){
        driver.close();
        driver = null;
    }
}
