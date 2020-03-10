package com.sdet.auto.TestHelper;

import com.deque.axe.AXE;
import com.sdet.auto.SeleniumExtensions.WebDriverBase;
import org.json.JSONArray;
import org.json.JSONObject;
import java.net.URL;

public class AccessibilityHelper {

    public static void basicAccessibilityCheck(TestAssert testAssert){

        URL scriptUrl = AccessibilityHelper.class.getResource("/axe.min.js");

        JSONObject responseJSON = new AXE.Builder(WebDriverBase.driver, scriptUrl).analyze();
        JSONArray violations = responseJSON.getJSONArray("violations");

        if (violations.length() == 0) {
            IoLibrary.writeLine("PASS: basicAccessibilityCheck | No violations found.");
        } else {
            AXE.writeResults("FAIL: " + IoLibrary.getTestName(), responseJSON);
            testAssert.setPass(false);
            IoLibrary.writeLine("FAIL: " + IoLibrary.getTestName() + " " + AXE.report(violations));
        }
    }
}
