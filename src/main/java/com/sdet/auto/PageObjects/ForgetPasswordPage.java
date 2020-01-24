package com.sdet.auto.PageObjects;

import com.sdet.auto.SeleniumExtensions.WebDriverExtensions;

public class ForgetPasswordPage extends WebDriverExtensions {

    private final static String txtEmail = "#email";
    private final static String btnRetrievePassword = ".icon-2x.icon-signin";

    public static void EnterEmail(String email){

        getElementBySelector(txtEmail).sendKeys(email);
    }

    public static void ClickRetrieveButton(){

        getElementBySelector(btnRetrievePassword).click();
    }
}
