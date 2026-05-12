package test;

import com.krce.Set_Up;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Screenshots;

public class LoginTest extends Set_Up {
    @Test
    public void testLogin() throws Exception {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com");
        Screenshots.takeScreenshot(driver, "HomePage");
        driver.quit();
    }
}