package pages;

import com.krce.Set_Up;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class IFrameTest extends Set_Up {
    String url="https://demoqa.com/frames";
    String url2="https://demoqa.com/nestedframes";
    @Test(priority = 1)
    public void frameParent() {
        driver.get(url);
        driver.switchTo().frame("frame1");
        String text = driver.findElement(By.id("sampleHeading")).getText();
        System.out.println(text);
        driver.switchTo().defaultContent();
        boolean displayed = driver.findElement(By.id("frame1")).isDisplayed();
        System.out.println(displayed);
    }
    @Test(priority = 2)
    public void frameChild() {
        driver.get(url2);
        driver.switchTo().frame("frame1");
        String parent = driver.findElement(By.tagName("body")).getText();
        System.out.println(parent);
        driver.switchTo().frame(0);
        String child = driver.findElement(By.tagName("p")).getText();
        System.out.println(child);
    }
}
