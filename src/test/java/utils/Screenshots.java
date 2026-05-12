package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Screenshots {
    public static void takeScreenshot(WebDriver driver, String testName) throws Exception {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String path = "screenshots/" + testName + ".png";
        File destination = new File(path);
        FileUtils.copyFile(source, destination);
        System.out.println("Screenshot saved");
    }
}