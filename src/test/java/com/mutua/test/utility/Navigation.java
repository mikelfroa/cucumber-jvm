package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;

public class Navigation extends BasePage {

    private static CargadorPropiedades cargador = new CargadorPropiedades();

    public static void goToPage(String page) {
        String url = null;
        switch (page) {
            case "PaginaCotizacion":
                url = (String)cargador.cargarPropiedades().get("urlCotizacion");
                break;
        }

        driver.get(url);
    }

}
