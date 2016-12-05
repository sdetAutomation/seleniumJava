package com.sdet.auto.TestHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSettings {

    public static String getWebUrl() {
        return webUrl;
    }

    public static void setWebUrl(String webUrl) {
        ConfigSettings.webUrl = webUrl;
    }

    public static String getWebBrowser() {
        return webBrowser;
    }

    public static void setWebBrowser(String webBrowser) {
        ConfigSettings.webBrowser = webBrowser;
    }

    private static String webUrl;
    private static String webBrowser;

    public void getConfigSettings() throws IOException {

        Properties property = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        property.load(inputStream);

        setWebUrl(property.getProperty("webUrl"));
        setWebBrowser(property.getProperty("webBrowser"));

        IoLibrary.writeLine("Test Config Settings");
        System.out.println(String.format("WebUrl: %s", getWebUrl()));
        System.out.println(String.format("WebBrowser: %s", getWebBrowser()));
        IoLibrary.writelineEnd();
    }
}
