package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class HomePage extends WebDriverBase{

    private static final String txtHeader = "#content h1";

    public static void VerifyOnHomePage(TestAssert testAssert) {

        String headerText = driver.findElement(By.cssSelector(txtHeader)).getText();
        testAssert.setPass(headerText.equals("Welcome to the Internet"));
    }
}
