package jobBoard.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity1 {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs");


    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void VerifyTitle(){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        Assert.assertEquals(websiteTitle,"Alchemy Jobs – Job Board Application","Title doesn't match, dismiss test!!!");
    }

}
