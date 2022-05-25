import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Activity12_3 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/popups");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);
        Assert.assertEquals(title, "Popups", "Title doesn't match");

        //Hover on SignIn button
        Actions action = new Actions(driver);
        WebElement signInBtn = driver.findElement(By.xpath("//button[text()='Sign In']"));
        action.moveToElement(signInBtn).pause(Duration.ofSeconds(2));
        System.out.println("Tooltip is:   "+signInBtn.getAttribute("data-tooltip"));
        signInBtn.click();


        //Login form
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement confirm = driver.findElement(By.id("action-confirmation"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(By.id("action-confirmation"),"Welcome Back, admin"));
        System.out.println("Confirmation message:  "+confirm.getText());
        driver.quit();
    }
}
