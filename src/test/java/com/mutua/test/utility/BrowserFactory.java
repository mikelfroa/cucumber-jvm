package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;

public class BrowserFactory extends BasePage {

    public static void getBrowser(String browserName)  {
        if (browserName == null ){
            browserName = "chrome";
        }
        switch (browserName) {
            case "firefox":
                    System.setProperty("webdriver.gecko.driver",(System.getProperty("user.dir") + "/src/test/resources/geckodriver.exe"));
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                break;
            case "chrome":
                    System.setProperty("webdriver.chrome.driver", (System.getProperty("user.dir") + "/src/test/resources/chromedriver.exe"));
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                break;
            case "edge":
                    System.setProperty("webdriver.edge.driver", (System.getProperty("user.dir") + "/src/test/resources/MicrosoftWebDriver.exe"));
                    driver = new EdgeDriver();
                    driver.manage().window().maximize();
                break;
        }

    }

    public static void closeBrowser(){
        driver.close();
        driver = null;
    }
}

