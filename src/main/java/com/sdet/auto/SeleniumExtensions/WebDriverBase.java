package com.sdet.auto.SeleniumExtensions;

import com.sdet.auto.TestHelper.IoLibrary;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverBase {

    public static WebDriver driver;

    public static void getWebDriver(String browser) {

        if(browser.equals("chrome")) {

            IoLibrary.writeLine("Launching Chrome Browser.");
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
            driver = new ChromeDriver(options);
            driver.manage().deleteAllCookies();

        } else if(browser.equals("firefox")) {
            System.setProperty("webdriver.gecko.driver", "src/main/resources/geckodriver");
            IoLibrary.writeLine("Launching Firefox Browser.");
            driver = new FirefoxDriver();
            driver.manage().window().maximize();

        } else if(browser.equals("seleniumGrid")) {
            IoLibrary.writeLine("Launching Browser Using Selenium Grid - Chrome Browser.");

            final String gridUrl = "http://y75EbcWLcnPNI0p8sZBQTcTUGj5PCOl0:LhvNjhomu4Z3Ue2d3tTMwDx3MtJe7V5I@SESYNPZ6.gridlastic.com:80/wd/hub";
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--start-maximized");
            options.addArguments("--disable-extensions");
            options.addArguments("disable-infobars");
            DesiredCapabilities capabilities = DesiredCapabilities.chrome();
            capabilities.setCapability(ChromeOptions.CAPABILITY, options);
            try {
                driver = new RemoteWebDriver(new URL(gridUrl), capabilities);
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            driver.manage().window().maximize();

        } else {
            throw new RuntimeException(String.format("Browser Type %s, not Found, please add additional code for this desired WebDriver Type.", browser));
        }
    }

    public static void getWebDriver (WebDriver chrome){
        driver = chrome;
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
    }
}
