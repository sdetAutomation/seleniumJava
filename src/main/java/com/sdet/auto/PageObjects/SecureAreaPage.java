package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class SecureAreaPage extends WebDriverBase {

    private final static String lblMessage = "#flash";
    private final static String btnLobout = ".icon-2x.icon-signout";

    public static void verifyMessage(TestAssert testAssert, String expectedMsg){

        testAssert.setPass(LoggingLibrary.CompareResultContains(driver.findElement(By.cssSelector(lblMessage)).getText(), expectedMsg));
    }

    public static void clickLogoutButton(){

        driver.findElement(By.cssSelector(btnLobout)).click();
    }
}
