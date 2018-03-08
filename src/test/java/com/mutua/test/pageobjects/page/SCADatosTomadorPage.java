package com.mutua.test.pageobjects.page;

import com.mutua.test.pageobjects.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SCADatosTomadorPage extends BasePage {

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
	private WebElement aseguradoDiaNac;

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
	private WebElement nuevoAsegurado;

	/* Identificador Condiciones Generales */
	@FindBy(id = "CondicionesGenerales")
	private WebElement condicionesGenerales;

	/* Identificador Calcular Precio */
	@FindBy(id = "tarificar")
	private WebElement tarificar;

	@FindBy(xpath = ".//*[@id='labelCond']/span/a")
	private WebElement linkCondiciones;

	public SCADatosTomadorPage(WebDriver driver) {
		super(driver);
	}

	public void rellenarFechaNacimiento(String dia, String mes, String ano){
        fld_tomadorDiaNac.sendKeys(dia);
        fld_tomadorMesNac.sendKeys(mes);
        fld_tomadorAnioNac.sendKeys(ano);
    }

    public void rellenarNif(String nif){
        fld_tomadorNif.sendKeys(nif);
    }

    public String verFechaEfecto(){
	    return cmb_fechaEfecto.getText();
    }

}
