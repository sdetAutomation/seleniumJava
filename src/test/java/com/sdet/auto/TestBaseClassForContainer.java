package com.sdet.auto;

import com.sdet.auto.TestHelper.ConfigSettings;
import com.sdet.auto.TestHelper.IoLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testcontainers.containers.BrowserWebDriverContainer;
import java.io.File;
import java.io.IOException;

import static org.testcontainers.containers.BrowserWebDriverContainer.VncRecordingMode.RECORD_ALL;

public class TestBaseClassForContainer {

    public RemoteWebDriver driver;
    public TestAssert testAssert;

    @Rule
    public TestRule watcher = new TestWatcher() {
        protected void starting(Description description) {
            System.out.println(" ");
            System.out.println("--------------------------------------------");
            System.out.println("Starting Test: " + description.getMethodName());
            System.out.println("--------------------------------------------");
            IoLibrary.setTestName(description.getMethodName());
        }
    };

    @Rule
    public BrowserWebDriverContainer chrome = new BrowserWebDriverContainer()
            .withRecordingMode(RECORD_ALL, new File("target"));

    @BeforeClass
    public static void MyClassInitialize() throws IOException {
        ConfigSettings configSettings = new ConfigSettings();
        configSettings.getConfigSettings();
    }

    @Before
    public void MyTestInitialize() {
        testAssert = new TestAssert();
        driver = chrome.getWebDriver();
    }

    @After
    public void MyTestCleanup(){
        Assert.assertTrue(testAssert.getPass());
    }
}
