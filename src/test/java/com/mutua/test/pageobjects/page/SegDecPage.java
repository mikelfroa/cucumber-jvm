package com.mutua.test.pageobjects.page;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SegDecPage extends BasePage {

	/* Identificador Tomador Dia Nacimiento */
	@FindBy(xpath = "//*[@href='https://wwwa.mutua.es/seguros-decesos/action/precarga-cotizacion']")
	private WebElement btn_calcPrecio;

	public void calcularPrecio(){
		btn_calcPrecio.click();
    }


}
