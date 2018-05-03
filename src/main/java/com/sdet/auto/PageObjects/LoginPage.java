package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class LoginPage extends WebDriverBase{

    private final static String txtUsername = "#username";
    private final static String txtPassword = "#password";
    private final static String btnLogin = ".fa.fa-2x.fa-sign-in";
    private final static String lblMessage = "#flash";

    public static void enterCredentials(String userId, String password){

        driver.findElement(By.cssSelector(txtUsername)).sendKeys(userId);
        driver.findElement(By.cssSelector(txtPassword)).sendKeys(password);
        driver.findElement(By.cssSelector(btnLogin)).click();
    }

    public static void verifyMessage(TestAssert testAssert, String expectedMsg){

        testAssert.setPass(LoggingLibrary.CompareResultContains(driver.findElement(By.cssSelector(lblMessage)).getText(), expectedMsg));
    }
}
