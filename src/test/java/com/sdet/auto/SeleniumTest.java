package com.sdet.auto;

import com.sdet.auto.PageObjects.*;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SeleniumTest extends TestBaseClass{

    @Test
    public void TC0001_SmokeTest() {

        GuiHelper.OpenWebBrowser();
        Navigation.NavToWebPageUnderTest();
        HomePage.VerifyOnHomePage(testAssert);
        GuiHelper.CloseWebBrowser();
    }

    @Test
    public void TC0002_ForgetPasswordTest() {

        final String email = "sdet.testautomation@gmail.com";
        final String expectedMsg = "Your e-mail's been sent!";

        GuiHelper.OpenWebBrowser();
        Navigation.NavToWebPageUnderTest();
        HomePage.ClickForgetPassword();
        ForgetPasswordPage.EnterEmail(email);
        ForgetPasswordPage.ClickRetrieveButton();
        EmailSentPage.VerifyEmailSent(testAssert, expectedMsg);
        GuiHelper.CloseWebBrowser();
    }

    @Test
    public void TC0003_FormAuthentication() {

        final String userId = "tomsmith";
        final String password = "SuperSecretPassword!";
        final String expectedLoginMsg = "You logged into a secure area!";
        final String expectedLogoutMsg = "You logged out of the secure area!";

        GuiHelper.OpenWebBrowser();
        Navigation.NavToWebPageUnderTest();
        HomePage.ClickFormAuthentication();
        LoginPage.EnterCredentials(userId, password);
        SecureAreaPage.VerifyMessage(testAssert, expectedLoginMsg);
        SecureAreaPage.ClickLogoutButton();
        LoginPage.VerifyMessage(testAssert, expectedLogoutMsg);
        GuiHelper.CloseWebBrowser();
    }

    @Test
    public void TC0004_FormAuthenticationBadInfo() {

        final String userId = "sdetAutomatiom";
        final String password = "pass@word";
        final String expectedMsg = "Your username is invalid!";

        GuiHelper.OpenWebBrowser();
        Navigation.NavToWebPageUnderTest();
        HomePage.ClickFormAuthentication();
        LoginPage.EnterCredentials(userId, password);
        LoginPage.VerifyMessage(testAssert, expectedMsg);
        GuiHelper.CloseWebBrowser();
    }
}
