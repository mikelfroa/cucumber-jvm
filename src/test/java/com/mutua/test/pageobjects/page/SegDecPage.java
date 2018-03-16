package com.mutua.test.pageobjects.page;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SegDecPage extends BasePage {

	/* Identificador Tomador Dia Nacimiento */
	@FindBy(linkText = "CALCULAR PRECIO")
	private WebElement btn_calcPrecio;

	public void calcularPrecio(){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btn_calcPrecio));
		btn_calcPrecio.click();
    }


}
