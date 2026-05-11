package com.krce;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PracticeForm extends Set_Up{
    @Test
    public void registration(){
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys("Pradeep");
        driver.findElement(By.id("lastName")).sendKeys("R");
        driver.findElement(By.id("userEmail")).sendKeys("pradeepr@gmail.com");
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        boolean status= driver.findElement(By.id("gender-radio-2")).isSelected();
        Assert.assertTrue(status);
        driver.findElement(By.id("userNumber")).sendKeys("9361337308");
        driver.findElement(By.id("subjectsInput")).sendKeys("Need to fill it");
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        boolean statusofsports= driver.findElement(By.id("hobbies-checkbox-1")).isSelected();
        Assert.assertTrue(statusofsports);
        driver.findElement(By.id("currentAddress")).sendKeys("No.3,Post office street");
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
        driver.findElement(By.id("submit")).click();
    }
}
