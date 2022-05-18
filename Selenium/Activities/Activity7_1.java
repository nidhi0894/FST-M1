import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_1 {

    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        driver.findElement(By.xpath("(//input[contains(@class,'username')])[1]")).sendKeys("admin");
        driver.findElement(By.xpath("(//input[contains(@class,'password')])[1]")).sendKeys("password");

        driver.findElement(By.xpath("//div[@class='ui form segment']//button[text()='Log in']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Welcome Back, admin"));

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());

        driver.quit();
    }

}
