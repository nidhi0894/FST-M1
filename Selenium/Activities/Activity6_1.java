import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_1 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement removeCheckboxBtn = driver.findElement(By.xpath("//button[@id='toggleCheckbox']"));
        removeCheckboxBtn.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//input[@type='checkbox']"))));

        removeCheckboxBtn.click();
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//input[@type='checkbox']"))));

        driver.quit();

    }
}
