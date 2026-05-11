package pages;

import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.time.Duration;

public class WebtableTest extends Set_Up {
    String url="https://demoqa.com/webtables";
    WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
    @Test(dataProvider = "Addrow",priority = 1)
    public void addRow(String fname, String lname, String email, String age, String salary, String dept ) {
        driver.get("https://demoqa.com/webtables");
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys(fname);
        driver.findElement(By.id("lastName")).sendKeys(lname);
        driver.findElement(By.id("userEmail")).sendKeys(email);
        driver.findElement(By.id("age")).sendKeys(age);
        driver.findElement(By.id("salary")).sendKeys(salary);
        driver.findElement(By.id("department")).sendKeys(dept);
        driver.findElement(By.id("submit")).click();
        boolean status = driver.getPageSource().contains("Pradeep");
        Assert.assertTrue(status);
    }
    @DataProvider(name = "Addrow")
    public Object[][] data() {
        return new Object[][]{
                {"Pradeep", "R", "pradeep@gmail.com", "24", "24000", "IT"
                }
        };
    }
    @Test(priority=2)
    public void search() {
        driver.get(url);
        driver.findElement(By.id("searchBox")).sendKeys("Pradeep");
        boolean status=driver.getPageSource().contains("Pradeep");
        Assert.assertTrue(status);
    }
    @Test(priority = 3)
    public void delete() throws InterruptedException{
        driver.get(url);
        driver.findElement(By.xpath("//div[@class='action-buttons']")).click();
    }
    @Test(priority = 4)
    public void pagination() {
        driver.get(url);
        WebElement nextButton = driver.findElement(By.xpath("//button[text()='Next']"));
        boolean status = nextButton.isEnabled();
        Assert.assertFalse(status);
    }
}
