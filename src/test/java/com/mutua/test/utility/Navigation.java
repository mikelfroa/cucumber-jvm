package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;

public class Navigation extends BasePage {

    private static CargadorPropiedades cargador = new CargadorPropiedades();

    public static String getTrunkURL() {
        String env = System.getProperty("env");
        if (env == null )
            env = "a";
        String trunk = (String)cargador.cargarPropiedades().get("urlHttp");
        trunk +=  env;
        trunk +=  cargador.cargarPropiedades().get("urlMutua");

        return trunk;
    }

    public static void goToPage(String page) {
        String url = Navigation.getTrunkURL();
        switch (page) {
            case "PaginaCotizacion":
                url +=  (String)cargador.cargarPropiedades().get("urlCotizacion");
                System.out.println(url);
                break;
        }

        driver.get(url);
    }


}
