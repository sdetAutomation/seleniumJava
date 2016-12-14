package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class SecureAreaPage extends WebDriverBase {

    private static String lblMessage = "#flash";
    private static String btnLobout = ".icon-2x.icon-signout";

    public static void VerifyMessage(TestAssert testAssert, String expectedMsg){

        testAssert.setPass(LoggingLibrary.CompareResultContains(driver.findElement(By.cssSelector(lblMessage)).getText(), expectedMsg));
    }

    public static void ClickLogoutButton(){

        driver.findElement(By.cssSelector(btnLobout)).click();
    }
}
