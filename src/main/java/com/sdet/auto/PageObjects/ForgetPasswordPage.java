package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import org.openqa.selenium.By;

public class ForgetPasswordPage extends WebDriverBase{

    private final static String txtEmail = "#email";
    private final static String btnRetrievePassword = ".icon-2x.icon-signin";

    public static void EnterEmail(String email){

        driver.findElement(By.cssSelector(txtEmail)).sendKeys(email);
    }

    public static void ClickRetrieveButton(){

        driver.findElement(By.cssSelector(btnRetrievePassword)).click();
    }

}
