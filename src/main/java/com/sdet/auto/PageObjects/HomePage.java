package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class HomePage extends WebDriverBase{

    private final static String txtHeader = ".heading";
    private final static String linkForgetPassword = "[href=\'/forgot_password\']";
    private final static String linkFormAuthentication = "[href=\'/login\']";

    public static void ClickForgetPassword(){
        driver.findElement(By.cssSelector(linkForgetPassword)).click();
    }

    public static void clickFormAuthentication(){
        driver.findElement(By.cssSelector(linkFormAuthentication)).click();
    }

    public static void VerifyOnHomePage(TestAssert testAssert) {

        String headerText = driver.findElement(By.cssSelector(txtHeader)).getText();
        testAssert.setPass(LoggingLibrary.CompareResult(headerText, "Welcome to the-internet"));
    }
}
