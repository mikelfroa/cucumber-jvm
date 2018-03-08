package com.mutua.test.pageobjects.page;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SCADatosTomadorPage extends BasePage {

	public SCADatosTomadorPage(WebDriver driver) {
		super(driver);
	}

	/* Identificador Tomador Dia Nacimiento */
	@FindBy(id = "tomador.diaNacimiento")
	private WebElement fld_tomadorDiaNac;

	/* Identificador Tomador Mes Nacimiento */
	@FindBy(id = "tomador.mesNacimiento")
	private WebElement fld_tomadorMesNac;

	/* Identificador Tomador Año Nacimiento */
	@FindBy(id = "tomador.anoNacimiento")
	private WebElement fld_tomadorAnioNac;

	/* Identificador Tomador Nif */
	@FindBy(id = "tomador.nif")
	private WebElement fld_tomadorNif;

	/* Identificador Fecha Efecto */
	@FindBy(id = "fechaEfecto")
	private WebElement cmb_fechaEfecto;

	/* Identificador Producto */
	@FindBy(id = "producto.codigo")
	private WebElement cmb_producto;

	/* Identificador CP */
	@FindBy(id = "delegacion.codigoPostal")
	private WebElement  fld_codigoPostal;

	/* Identificador Localidad */
	@FindBy(id = "nombreLocalidad")
	private WebElement cmb_localidad;

	/* Identificador Tomador Asegurado */
	@FindBy(id = "tomador.asegurado")
	private WebElement rad_asegurado;

	/* Identificador Asegurado Dia Nacimiento */
	@FindBy(id = "asegurados.diaNacimiento1")
	private WebElement fld_aseguradoDiaNac;

	/* Identificador Asegurado Mes Nacimiento */
	@FindBy(id = "asegurados.mesNacimiento1")
	private WebElement fld_aseguradoMesNac;

	/* Identificador Asegurado Año Nacimiento */
	@FindBy(id = "asegurados.anoNacimiento1")
	private WebElement fld_aseguradoAnioNac;

	/* Identificador Asegurado 2 Dia Nacimiento */
	@FindBy(id = "asegurados.diaNacimiento2")
	private WebElement fld_asegurado2DiaNac;

	/* Identificador Asegurado 2 Mes Nacimiento */
	@FindBy(id = "asegurados.mesNacimiento2")
	private WebElement asegurado2MesNac;

	/* Identificador Asegurado 2 Año Nacimiento */
	@FindBy(id = "asegurados.anoNacimiento2")
	private WebElement asegurado2AnioNac;

	/* Identificador Nuevo Asegurado */
	@FindBy(id = "nuevoAsegurado")
	private WebElement btn_nuevoAsegurado;

	/* Identificador Condiciones Generales */
	@FindBy(id = "CondicionesGenerales")
	private WebElement ckb_condicionesGenerales;

	/* Identificador Calcular Precio */
	@FindBy(id = "tarificar")
	private WebElement btn_tarificar;

	@FindBy(xpath = ".//*[@id='labelCond']/span/a")
	private WebElement linkCondiciones;

	public void rellenarFechaNacimiento(String dia, String mes, String ano){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_tomadorDiaNac));
		fld_tomadorDiaNac.sendKeys(dia);
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_tomadorMesNac));
		fld_tomadorMesNac.sendKeys(mes);
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_tomadorAnioNac));
		fld_tomadorAnioNac.sendKeys(ano);
    }

    public void rellenarNif(String nif){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_tomadorNif));
		fld_tomadorNif.sendKeys(nif);
    }

    public String verFechaEfecto(){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cmb_fechaEfecto));
		return cmb_fechaEfecto.getText();
    }

    public void seleccionarProducto(String producto) {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(cmb_producto));
		cmb_producto.sendKeys(producto);
    }

	public void rellenarCodigoPostal(String codpostal) {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_codigoPostal));
		fld_codigoPostal.sendKeys(codpostal);
	}

	public void añadirAsegurado() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btn_nuevoAsegurado));
		btn_nuevoAsegurado.click();
	}

	public void rellenarFechaNacimientoNuevoAsegurado(String dia, String mes, String ano){
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(fld_asegurado2DiaNac));
		fld_asegurado2DiaNac.sendKeys(dia);
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(asegurado2MesNac));
		asegurado2MesNac.sendKeys(mes);
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(asegurado2AnioNac));
		asegurado2AnioNac.sendKeys(ano);
	}

	public void aceptoCondGen() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(ckb_condicionesGenerales));
		ckb_condicionesGenerales.click();
	}

	public void calculoTarifa() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(btn_tarificar));
		btn_tarificar.click();
	}

	public void tomadorEsAsegurado() {
		new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(rad_asegurado));
		rad_asegurado.click();
	}
}
