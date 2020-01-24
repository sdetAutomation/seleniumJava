package com.sdet.auto;

import com.sdet.auto.TestHelper.ConfigSettings;
import com.sdet.auto.TestHelper.IoLibrary;
import com.sdet.auto.TestHelper.TestAssert;
import org.junit.*;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.io.IOException;

public class TestBaseClass {

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

    @BeforeClass
    public static void MyClassInitialize() throws IOException {
        ConfigSettings configSettings = new ConfigSettings();
        configSettings.getConfigSettings();
    }

    @Before
    public void MyTestInitialize() {
        testAssert = new TestAssert();
    }

    @After
    public void MyTestCleanup(){
        Assert.assertTrue(testAssert.getPass());
    }
}
