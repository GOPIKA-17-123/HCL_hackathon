package com.krce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.Screenshots;

import java.time.Duration;
public class Set_Up {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeMethod
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterMethod
    public void tearDown(ITestResult result) throws Exception {
        if (ITestResult.FAILURE == result.getStatus()) {
            Screenshots.takeScreenshot(driver, result.getName());
        }
        driver.quit();
    }
}