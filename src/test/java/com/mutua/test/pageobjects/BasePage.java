package com.mutua.test.pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {

    public static WebDriver driver;

    public BasePage(){
        PageFactory.initElements(driver, this);

    }

    public static void getBrowser(String browserName)  {
        if (browserName == null ){
            browserName = "firefox";
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

    public static void closeBrowser(){
        driver.close();
        driver = null;
    }

}