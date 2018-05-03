package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.ConfigSettings;
import org.openqa.selenium.WebDriver;

import static com.sdet.auto.SeleniumExtensions.WebDriverBase.getWebDriver;

public class GuiHelper {

    public static void openWebBrowser(){
        getWebDriver(ConfigSettings.getWebBrowser());
    }

    public static void openWebBrowser(WebDriver chrome){
        getWebDriver(chrome);
    }

    public static void closeWebBrowser(){
        WebDriverBase.driver.close();
        WebDriverBase.driver.quit();
    }
}