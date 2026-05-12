package pages;
import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
public class WidgetTest extends Set_Up {
     String dateurl="https://demoqa.com/date-picker";
    @Test(priority=1)
    public void datePicker(){
        driver.get(dateurl);
        WebElement date = driver.findElement(By.id("datePickerMonthYearInput"));
        date.sendKeys(Keys.CONTROL + "a");
        date.sendKeys("07/20/2026");
        date.sendKeys(Keys.ENTER);
        String selectedDate = date.getAttribute("value");
        System.out.println(selectedDate);
        Assert.assertEquals(selectedDate, "07/20/2026");
    }
    @Test(priority=2)
    public void slider() {
        driver.get("https://demoqa.com/slider");
        WebElement slider = driver.findElement(By.xpath("//input[@type='range']"));
        Actions actions = new Actions(driver);
        actions.dragAndDropBy(slider, 50, 0).perform();
        String value = slider.getAttribute("value");
        System.out.println(value);
    }
    @Test(priority=3)
    public void accordian() {
        driver.get("https://demoqa.com/accordian");
        driver.findElement(By.xpath("//button[@class='accordion-button collapsed']")).click();
        driver.findElement(By.xpath("//div[@class='accordion-body']")).isDisplayed();

    }
}
