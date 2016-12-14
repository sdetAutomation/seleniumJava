package com.sdet.auto.PageObjects;


import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import com.sdet.auto.TestHelper.LoggingLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.openqa.selenium.By;

public class EmailSentPage extends WebDriverBase{

    private final static String txtMessage = "#content";

    public static void VerifyEmailSent(TestAssert testAssert, String expectedMsg){

        testAssert.setPass(LoggingLibrary.CompareResult(driver.findElement(By.cssSelector(txtMessage)).getText(), expectedMsg));
    }
}
