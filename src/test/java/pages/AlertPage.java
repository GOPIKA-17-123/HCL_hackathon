package pages;

import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class AlertPage extends Set_Up {
    String url="https://demoqa.com/alerts";
    @Test(priority = 1)
    public void simpleAlert() {
        driver.get(url);
        driver.findElement(By.id("alertButton")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
        Assert.assertTrue(alertText.contains("You clicked"));
    }
    @Test(priority = 2)
    public void confirmAlert() {
        driver.get(url);
        driver.findElement(By.id("confirmButton")).click();
        driver.switchTo().alert().dismiss();
        String result = driver.findElement(By.id("confirmResult")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("Cancel"));
    }
    @Test(priority = 3)
    public void promptAlert() {
        driver.get(url);
        driver.findElement(By.id("promtButton")).click();
        driver.switchTo().alert().sendKeys("Pradeep");
        driver.switchTo().alert().accept();
        String result = driver.findElement(By.id("promptResult")).getText();
        System.out.println(result);
        Assert.assertTrue(result.contains("Pradeep"));
    }
    @Test(priority = 4)
    public void newTabWindow() {
        driver.get("https://demoqa.com/browser-windows");
        String parentWindow = driver.getWindowHandle();
        driver.findElement(By.id("tabButton")).click();
        Set<String> allWindows = driver.getWindowHandles();
        for (String window : allWindows) {
            if (!window.equals(parentWindow)) {
                driver.switchTo().window(window);
                break;
            }
        }
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));
        String title = driver.getTitle();
        System.out.println("Title is: " + title);
        Assert.assertFalse(title.contains("DEMOQA"));
        driver.close();
        driver.switchTo().window(parentWindow);
    }
}

