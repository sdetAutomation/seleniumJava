package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.ConfigSettings;

public class Navigation extends WebDriverBase{

    public static void NavToWebPageUnderTest(){
        driver.get(ConfigSettings.getWebUrl());
    }
}
