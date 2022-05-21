package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    //Global object
    WebDriver driver;

    @Test
    public void HomePageTest(){
        System.out.println("Title:      "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Training Support","Title doesn't match");
        driver.findElement(By.id("about-link")).click();

        System.out.println("New page title is: " + driver.getTitle());

        Assert.assertEquals(driver.getTitle(), "About Training Support");
    }
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
