package com.sdet.auto;

import com.sdet.auto.PageObjects.GuiHelper;
import com.sdet.auto.PageObjects.HomePage;
import com.sdet.auto.PageObjects.Navigation;
import org.junit.Test;

public class SeleniumTest extends TestBaseClass{

    @Test
    public void TC0001_Smoketest() {

        GuiHelper.OpenWebBrowser();
        Navigation.NavToWebPageUnderTest();
        HomePage.VerifyOnHomePage();
        GuiHelper.CloseWebBrowser();
    }
}