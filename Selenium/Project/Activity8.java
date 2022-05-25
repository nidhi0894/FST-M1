package jobBoard.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity8 {
    WebDriver driver;

    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "root", "pa$$w0rd" },
        };
    }

    @Test(dataProvider = "Authentication")
    public void VerifyLogin(String username, String password){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));

        WebElement enterUsername = driver.findElement(By.id("user_login"));
        enterUsername.clear();
        enterUsername.sendKeys(username);

        WebElement enterPassword = driver.findElement(By.id("user_pass"));
        enterPassword.clear();
        enterPassword.sendKeys(password);

        driver.findElement(By.id("wp-submit")).click();

        String verifyLogin = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(verifyLogin,"Dashboard", "User login not verified");
        System.out.println("User logged in successfully");
    }
}
