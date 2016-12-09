package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import org.openqa.selenium.By;
import sun.jvm.hotspot.utilities.Assert;


public class HomePage extends WebDriverBase{

    private static final String txtHeader = "#content h1";

    public static void VerifyOnHomePage(){

        String headerText = driver.findElement(By.cssSelector(txtHeader)).getText();
        Assert.that(headerText.equals("Welcome to the Internet"), "VerifyOnHomePage");
    }
}
