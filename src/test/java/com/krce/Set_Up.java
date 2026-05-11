package com.krce;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.time.Duration;

public class Set_Up {
    public WebDriver driver;
    public WebDriverWait wait;
    @BeforeTest
    public void setUp(){
        driver=new ChromeDriver();
        driver.get("https://demoqa.com/");
        driver.manage().window().maximize();
        wait= new WebDriverWait(driver, Duration.ofSeconds(20));
    }
    @AfterTest
    public void teatDown() throws InterruptedException{
        driver.quit();
    }
}
