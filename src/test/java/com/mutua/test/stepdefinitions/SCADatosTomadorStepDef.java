package com.mutua.test.stepdefinitions;

import com.mutua.test.pageobjects.page.SCADatosTomadorPage;
import com.mutua.test.utility.DriverFactory;
import com.mutua.test.utility.GeneralUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class SCADatosTomadorStepDef {

    private WebDriver driver;
    SCADatosTomadorPage scaDatosTomadorPage;

    @Given("^estoy en la pagina de precarga de cotización$")
    public void estoyEnLaPaginaDePrecargaDeCotización() throws Throwable {
        driver = new DriverFactory().getDriver();
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("Estoy en la página", driver.getCurrentUrl().equalsIgnoreCase("https://wwwd.mutua.es/seguros-decesos/action/precarga-cotizacion"));

    }

    @And("^introduzco la fecha de nacimiento: (\\d+), (\\d+), (\\d+)$")
    public void introduzcoLaFechaDeNacimiento(String dia, String mes, String ano) throws Throwable {
        driver = new DriverFactory().getDriver();
        scaDatosTomadorPage = new SCADatosTomadorPage(driver);
        scaDatosTomadorPage.rellenarFechaNacimiento(dia, mes, ano);
    }

    @And("^introduzco el nif: \"([^\"]*)\"$")
    public void introduzcoElNif(String nif) throws Throwable {
        driver = new DriverFactory().getDriver();
        scaDatosTomadorPage = new SCADatosTomadorPage(driver);
        scaDatosTomadorPage.rellenarNif(nif);
    }
}
