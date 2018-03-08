package com.mutua.test.stepdefinitions;

import com.mutua.test.pageobjects.page.SCADatosTomadorPage;
import com.mutua.test.utility.DriverFactory;
import com.mutua.test.utility.GeneralUtils;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class SCADatosTomadorStepDef {

    private WebDriver driver;
    SCADatosTomadorPage scaDatosTomadorPage;

    @Given("^estoy en la pagina de precarga de cotización$")
    public void estoyEnLaPaginaDePrecargaDeCotización() throws Throwable {
        driver = new DriverFactory().getDriver();
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("Estoy en la página", driver.getCurrentUrl().equalsIgnoreCase("https://wwwa.mutua.es/seguros-decesos/action/precarga-cotizacion"));

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
        Thread.sleep(20000);
    }

    @And("^verifico la fecha de efecto$")
    public void verificoLaFechaDeEfecto() throws Throwable {
        scaDatosTomadorPage = new SCADatosTomadorPage(driver);
        try {
            Calendar c = Calendar.getInstance();
            c.set(Calendar.DAY_OF_MONTH, 1);
            System.out.println(scaDatosTomadorPage.verFechaEfecto());
            System.out.println(new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));
            Assert.assertEquals("fecha de efecto está precargada con el dia uno del mes",scaDatosTomadorPage.verFechaEfecto(),new SimpleDateFormat("dd/MM/yyyy").format(c.getTime()));

        } catch (Exception e) {
            throw new Exception("ERROR: La fecha de efecto no se corresponde el días uno del mes en curso");
        }
    }

    @And("^selecciono el producto: \"([^\"]*)\"$")
    public void seleccionoElProducto(String producto) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^introduzco el codigo postal: \"([^\"]*)\"$")
    public void introduzcoElCodigoPortal(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^selecciono la localidad: \"([^\"]*)\"$")
    public void seleccionoLaLocalidad(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^añado nuevo asegurado$")
    public void añadoNuevoAsegurado() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^introduzco la fecha de nacimiento del segundo asegurado: (\\d+), (\\d+), (\\d+)$")
    public void introduzcoLaFechaDeNacimientoDelSegundoAsegurado(int arg0, int arg1, int arg2) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^acepto las condiciones generales$")
    public void aceptoLasCondicionesGenerales() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Cuando("^calculo la tarificación$")
    public void calculoLaTarificación() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Entonces("^estoy en la pagina de presupuesto$")
    public void estoyEnLaPaginaDePresupuesto() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^las frecuencias de pago sean correctas$")
    public void lasFrecuenciasDePagoSeanCorrectas() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Cuando("^añado pack ADN$")
    public void añadoPackADN() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^recalculo la tarificación$")
    public void recalculoLaTarificación() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
