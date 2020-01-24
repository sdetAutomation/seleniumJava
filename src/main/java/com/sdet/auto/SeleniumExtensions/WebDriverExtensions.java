package com.sdet.auto.SeleniumExtensions;

import com.sdet.auto.TestHelper.IoLibrary;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import static com.sdet.auto.SeleniumExtensions.WebDriverBase.driver;

public class WebDriverExtensions {

    public static WebElement getElementBySelector(String cssSelector){
        return waitForElement(By.cssSelector(cssSelector), 10);
    }

    public static WebElement getElementBySelector(String cssSelector, long waitSeconds){
        return waitForElement(By.cssSelector(cssSelector), waitSeconds);
    }

    public static WebElement waitForElement(By locator, long waitSeconds) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, waitSeconds);
            return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }
        catch(RuntimeException ex){
            seleniumExceptionHandler(ex);
            throw(ex);
        }
    }

    public static void seleniumExceptionHandler(Exception ex) {
        String exceptionName = ex.getMessage();
        IoLibrary.writeLine(String.format("WebDriver Exception Handler Caught Exception: [%s]", exceptionName));
        screenshot();
        IoLibrary.writelineEnd();
    }

    public static void screenshot() {
        File screenshot;
        String testName = String.format(IoLibrary.getTestName() + "_" + IoLibrary.getUniqueIdentifier() + ".Png");

        try {
            System.out.println("Attempting Selenium Screenshot  ...");
            Thread.sleep(1000);
            screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotDir = IoLibrary.getDirPath() + "/target/outputs/screenshots/";
            File dir = new File(screenshotDir);

            if (!dir.exists()) {
                IoLibrary.writeLine("No Folder Found");
                dir.mkdirs();
                System.out.println(String.format("Folder created : [%1s]", screenshotDir));
                IoLibrary.writelineEnd();
            }

            BufferedImage im = null;
            String textToWrite = driver.getCurrentUrl();
            Font myFont = new Font("Times New Roman", Font.PLAIN, 20);
            im = ImageIO.read(screenshot);
            Graphics2D g2 = im.createGraphics();

            // get text length
            AffineTransform affinetransform = new AffineTransform();
            FontRenderContext frc = new FontRenderContext(affinetransform, true, true);
            int textWidth = (int) (myFont.getStringBounds(textToWrite, frc).getWidth());
            int textHeight = (int) (myFont.getStringBounds(textToWrite, frc).getHeight());
            // set color and size of text box behind text.
            g2.setColor(Color.white);
            g2.fillRect(0, 0, textWidth, textHeight);
            // set text attributes.
            g2.setFont(myFont);
            g2.setColor(Color.black);
            g2.drawString(textToWrite, 0, 20);
            // write image file to save location
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(im, "png", baos);
            FileOutputStream fos = null;
            fos = new FileOutputStream(screenshotDir + testName);
            System.out.println(String.format("Browser Screenshot Save Location: %1s", screenshotDir + testName));
            fos.write(baos.toByteArray());
            fos.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
