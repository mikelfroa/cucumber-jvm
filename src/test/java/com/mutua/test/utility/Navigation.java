package com.mutua.test.utility;

import com.mutua.test.pageobjects.BasePage;

public class Navigation extends BasePage {

    public static String getTrunkPortalURL() {
        String env = System.getProperty("env");
        if (env == null )
            env = "qa";
        //String trunk = "https://www" + env + ".mutua.es/";
        String trunk = "https://www.mutua.es/";
        if (env == "local"){
            String address = System.getProperty("serverAddress");
            String port = System.getProperty("serverPort");
            if (address != null && !address.isEmpty()) {
                trunk = "http://"+address;
                if (port != null && !port.isEmpty()) {
                    trunk += ":"+port;
                }
            }
            else
                trunk = "http://localhost:8888";

        }
        return trunk;
    }

    public static void goToPage(String page) {
        String url = Navigation.getTrunkPortalURL();
        switch (page) {
            case "HomePage":
                //url = url;
                break;
        }

        driver.get(url);
    }

}
