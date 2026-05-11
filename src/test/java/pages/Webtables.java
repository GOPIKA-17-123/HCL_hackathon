package pages;

import com.krce.Set_Up;
import org.openqa.selenium.By;

public class Webtables extends Set_Up {
    public void addRow() {
        driver.findElement(By.id("addNewRecordButton")).click();
        driver.findElement(By.id("firstName")).sendKeys("");
    }
}
