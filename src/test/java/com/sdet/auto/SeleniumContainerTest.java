package com.sdet.auto;

import com.sdet.auto.PageObjects.*;
import com.sdet.auto.TestHelper.AccessibilityHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Category(com.sdet.auto.groups.ContainersTest.class)
public class SeleniumContainerTest extends TestBaseClassForContainer {

    @Test
    public void TC0001_SmokeTest() {

        GuiHelper.openWebBrowser(driver);
        Navigation.navToWebPageUnderTest();
        HomePage.VerifyOnHomePage(testAssert);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0002_ForgetPasswordTest() {

        final String email = "sdet.testautomation@gmail.com";
        final String expectedMsg = "Your e-mail's been sent!";

        GuiHelper.openWebBrowser(driver);
        Navigation.navToWebPageUnderTest();
        HomePage.ClickForgetPassword();
        ForgetPasswordPage.EnterEmail(email);
        ForgetPasswordPage.ClickRetrieveButton();
        EmailSentPage.VerifyEmailSent(testAssert, expectedMsg);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0003_FormAuthentication() {

        final String userId = "tomsmith";
        final String password = "SuperSecretPassword!";
        final String expectedLoginMsg = "You logged into a secure area!";
        final String expectedLogoutMsg = "You logged out of the secure area!";

        GuiHelper.openWebBrowser(driver);
        Navigation.navToWebPageUnderTest();
        HomePage.clickFormAuthentication();
        LoginPage.enterCredentials(userId, password);
        SecureAreaPage.verifyMessage(testAssert, expectedLoginMsg);
        SecureAreaPage.clickLogoutButton();
        LoginPage.verifyMessage(testAssert, expectedLogoutMsg);
        GuiHelper.closeWebBrowser();
    }

    @Test
    public void TC0004_FormAuthenticationBadInfo() {

        final String userId = "sdetAutomatiom";
        final String password = "pass@word";
        final String expectedMsg = "Your username is invalid!";

        GuiHelper.openWebBrowser(driver);
        Navigation.navToWebPageUnderTest();
        HomePage.clickFormAuthentication();
        LoginPage.enterCredentials(userId, password);
        LoginPage.verifyMessage(testAssert, expectedMsg);
        GuiHelper.closeWebBrowser();
    }

//    // below is an example of an axe accessibility test.  Below test is suppose to fail.  Commented out.
//    @Test
//    public void TC0005_A11y_Accessibility() {
//
//        GuiHelper.openWebBrowser(driver);
//        Navigation.navToWebPageUnderTest();
//
//        AccessibilityHelper.basicAccessibilityCheck(testAssert);
//
//        GuiHelper.closeWebBrowser();
//    }
}
