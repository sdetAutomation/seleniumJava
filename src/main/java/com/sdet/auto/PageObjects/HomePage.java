package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverExtensions;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;

public class HomePage extends WebDriverExtensions {

    private final static String txtHeader = ".heading";
    private final static String linkForgetPassword = "[href=\'/forgot_password\']";
    private final static String linkFormAuthentication = "[href=\'/login\']";

    public static void ClickForgetPassword(){
        getElementBySelector(linkForgetPassword).click();
    }

    public static void clickFormAuthentication(){
        getElementBySelector(linkFormAuthentication).click();
    }

    public static void VerifyOnHomePage(TestAssert testAssert) {

        String headerText = getElementBySelector(txtHeader).getText();
        testAssert.setPass(LoggingLibrary.CompareResult(headerText, "Welcome to the-internet"));
    }
}
