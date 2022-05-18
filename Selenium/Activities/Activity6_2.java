import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity6_2 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/ajax");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        driver.findElement(By.xpath("//button[@class='ui violet button']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "HELLO!"));

//        String getText = driver.findElement(By.tagName("h3")).getText();
        System.out.println(driver.findElement(By.tagName("h3")).getText());

        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("ajax-content"), "I'm late!"));

        System.out.println(driver.findElement(By.tagName("h3")).getText());
        driver.quit();
    }
}
