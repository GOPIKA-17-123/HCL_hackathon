package pages;
import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
public class FormTest extends Set_Up {
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
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        WebElement state = wait.until(ExpectedConditions.elementToBeClickable(By.id("state")));
        state.click();
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(text(),'NCR')]"))).click();
        driver.findElement(By.id("submit")).click();
    }
    @DataProvider(name = "formData")
    public Object[][] data() {
        return new Object[][]{
                {
                    "Pradeep", "R", "pradeep@gmail.com", "9361337308", "Chennai"
                }

        };
    }
}