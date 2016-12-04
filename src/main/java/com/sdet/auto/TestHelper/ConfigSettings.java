package com.sdet.auto.TestHelper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigSettings {

    public static String webUrl;
    public static String webBrowser;

    public void getConfigSettings() throws IOException {

        Properties property = new Properties();
        String propFileName = "config.properties";
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);
        property.load(inputStream);

        webUrl = property.getProperty("webUrl");
        webBrowser = property.getProperty("webBrowser");

        IoLibrary.writeLine("Test Config Settings");
        System.out.println(String.format("WebUrl: %s", webUrl));
        System.out.println(String.format("WebBrowser: %s", webBrowser));
        IoLibrary.writelineEnd();
    }
}
