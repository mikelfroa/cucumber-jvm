package com.mutua.test.pageobjects.page;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Button productos
    @FindBy(xpath = "//*[@class='hasSubmenu firstLevel']/1")
    private WebElement btn_Productos;

    public void goToProductos() {
        new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btn_Productos));
        btn_Productos.click();

    }


}
