package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Activity6 {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/login-form");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    @Parameters({"user", "password"})
    public void UserLogin(String user, String password){

        String title = driver.getTitle();
        System.out.println("Title:      "+driver.getTitle());

        driver.findElement(By.id("username")).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(password);

        driver.findElement(By.xpath("//button[@type='submit']")).click();

        String confirmText = driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals(confirmText,"Welcome Back, admin", "Confirmation text doesn't match!!");
        System.out.println(confirmText +":    text is validated successfully");

    }
}
