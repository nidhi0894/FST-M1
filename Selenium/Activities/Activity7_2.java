import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity7_2 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-attributes");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        driver.findElement(By.xpath("(//input[contains(@class,'username')])[2]")).sendKeys("user123");
        driver.findElement(By.xpath("(//input[contains(@class,'password')])[2]")).sendKeys("password123");

        driver.findElement(By.xpath("//label[text()='Confirm Password']/following-sibling::input")).sendKeys("password123");
        driver.findElement(By.xpath("//input[@type='email']")).sendKeys("username@gmail.com");

        driver.findElement(By.xpath("//div[@class='ui form segment']//button[text()='Sign Up']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"), "Thank you for registering, user"));

        System.out.println(driver.findElement(By.id("action-confirmation")).getText());

        driver.quit();
    }
}
