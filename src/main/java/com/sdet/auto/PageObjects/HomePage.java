package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class HomePage extends WebDriverBase{

    private final static String txtHeader = "#content h1";
    private final static String linkForgetPassword = "[href=\'/forgot_password\']";
    private final static String linkFormAuthentication = "[href=\'/login\']";

    public static void ClickForgetPassword(){
        driver.findElement(By.cssSelector(linkForgetPassword)).click();
    }

    public static void ClickFormAuthentication(){
        driver.findElement(By.cssSelector(linkFormAuthentication)).click();
    }

    public static void VerifyOnHomePage(TestAssert testAssert) {

        String headerText = driver.findElement(By.cssSelector(txtHeader)).getText();
        testAssert.setPass(headerText.equals("Welcome to the Internet"));
    }
}
