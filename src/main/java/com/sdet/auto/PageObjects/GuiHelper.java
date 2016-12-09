package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.ConfigSettings;

import static com.sdet.auto.SeleniumExtensions.WebDriverBase.GetWebDriver;

public class GuiHelper {

    public static void OpenWebBrowser(){
        GetWebDriver(ConfigSettings.getWebBrowser());
    }

    public static void CloseWebBrowser(){
        WebDriverBase.driver.close();
        WebDriverBase.driver.quit();
    }
}