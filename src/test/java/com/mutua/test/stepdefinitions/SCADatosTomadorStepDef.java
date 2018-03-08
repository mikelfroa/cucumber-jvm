package com.mutua.test.stepdefinitions;

import com.mutua.test.pageobjects.page.SCADatosTomadorPage;
import com.mutua.test.utility.GeneralUtils;
import com.mutua.test.utility.Navigation;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.es.Cuando;
import cucumber.api.java.es.Entonces;
import cucumber.api.java.es.Y;
import org.junit.Assert;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class SCADatosTomadorStepDef {

    SCADatosTomadorPage scaDatosTomadorPage = new SCADatosTomadorPage();

    @Given("^estoy en la pagina de precarga de cotización$")
    public void estoyEnLaPaginaDePrecargaDeCotización() throws Throwable {
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("Estoy en la página", scaDatosTomadorPage.getURL().equalsIgnoreCase(Navigation.getTrunkURL() + "seguros-decesos/action/precarga-cotizacion"));

    }

    @And("^introduzco la fecha de nacimiento: (\\d+), (\\d+), (\\d+)$")
    public void introduzcoLaFechaDeNacimiento(String dia, String mes, String ano)  {
        scaDatosTomadorPage.rellenarFechaNacimiento(dia, mes, ano);
    }

    @And("^introduzco el nif: \"([^\"]*)\"$")
    public void introduzcoElNif(String nif)  {
        scaDatosTomadorPage.rellenarNif(nif);
    }

    @And("^verifico la fecha de efecto$")
    public void verificoLaFechaDeEfecto() throws Throwable {
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
    public void seleccionoElProducto(String producto)  {
        scaDatosTomadorPage.seleccionarProducto(producto);
    }

    @And("^introduzco el codigo postal: \"([^\"]*)\"$")
    public void introduzcoElCodigoPortal(String codpostal)  {
        scaDatosTomadorPage.rellenarCodigoPostal(codpostal);
    }

    @Y("^añado nuevo asegurado$")
    public void añadoNuevoAsegurado()  {
        scaDatosTomadorPage.añadirAsegurado();
    }

    @Y("^introduzco la fecha de nacimiento del segundo asegurado: (\\d+), (\\d+), (\\d+)$")
    public void introduzcoLaFechaDeNacimientoDelSegundoAsegurado(String dia, String mes, String ano) throws Throwable {
        scaDatosTomadorPage.rellenarFechaNacimientoNuevoAsegurado(dia,mes,ano);
    }

    @Y("^acepto las condiciones generales$")
    public void aceptoLasCondicionesGenerales() throws InterruptedException {
        scaDatosTomadorPage.aceptoCondGen();
        Thread.sleep(10000);
    }

    @Cuando("^calculo la tarificación$")
    public void calculoLaTarificación() throws InterruptedException {
        scaDatosTomadorPage.calculoTarifa();
        Thread.sleep(10000);
    }

    @Entonces("^estoy en la pagina de presupuesto$")
    public void estoyEnLaPaginaDePresupuesto() throws Throwable {
        GeneralUtils.waitForPageLoaded();
        Assert.assertTrue("Estoy en la página de presupuesto", scaDatosTomadorPage.getURL().equalsIgnoreCase(Navigation.getTrunkURL() + "/action/cotizarDecesos"));

    }

    @Cuando("^añado pack ADN$")
    public void añadoPackADN()  {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^recalculo la tarificación$")
    public void recalculoLaTarificación()  {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Y("^selecciono que el tomador es también el asegurado$")
    public void seleccionoSiElTomadorEsTambiénElAsegurado()  {
        scaDatosTomadorPage.tomadorEsAsegurado();

    }
}
