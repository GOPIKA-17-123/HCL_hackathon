package pages;

import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class FormPage extends Set_Up {
    WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
    @Test(dataProvider = "formData")
    public void registration(String fname, String lname, String email, String phone, String address) {
        driver.get("https://demoqa.com/automation-practice-form");
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.xpath("//label[text()='Female']")).click();
        boolean status = driver.findElement(By.id("gender-radio-2")).isSelected();
        Assert.assertTrue(status);
        driver.findElement(By.id("userNumber")).sendKeys(phone);
        driver.findElement(By.id("subjectsInput")).sendKeys("Testing");
        driver.findElement(By.xpath("//label[text()='Sports']")).click();
        boolean statusofsports = driver.findElement(By.id("hobbies-checkbox-1")).isSelected();
        Assert.assertTrue(statusofsports);
        driver.findElement(By.id("currentAddress")).sendKeys(address);
        driver.findElement(By.id("state")).click();
        driver.findElement(By.xpath("//div[text()='NCR']")).click();
        driver.findElement(By.id("city")).click();
        driver.findElement(By.xpath("//div[text()='Delhi']")).click();
        driver.findElement(By.id("submit")).click();
    }

    @DataProvider(name = "formData")
    public Object[][] data() {
        return new Object[][]{
                {"Pradeep", "R", "pradeep@gmail.com", "9361337308", "Chennai"
                }
        };
    }
}