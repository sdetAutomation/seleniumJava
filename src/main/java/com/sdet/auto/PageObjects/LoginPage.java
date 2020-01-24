package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverExtensions;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;

public class LoginPage extends WebDriverExtensions {

    private final static String txtUsername = "#username";
    private final static String txtPassword = "#password";
    private final static String btnLogin = ".fa.fa-2x.fa-sign-in";
    private final static String lblMessage = "#flash";

    public static void enterCredentials(String userId, String password){

        getElementBySelector(txtUsername).sendKeys(userId);
        getElementBySelector(txtPassword).sendKeys(password);
        getElementBySelector(btnLogin).click();
    }

    public static void verifyMessage(TestAssert testAssert, String expectedMsg){

        testAssert.setPass(LoggingLibrary.CompareResultContains(getElementBySelector(lblMessage).getText(), expectedMsg));
    }
}
