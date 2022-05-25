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
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity4 {
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
    public void VerifySecondHeading(){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h2")));
        WebElement heading2 = driver.findElement(By.tagName("h2"));

        Actions action = new Actions(driver);
        action.moveToElement(heading2);

        String headingTxt = heading2.getText();
        System.out.println("Heading text:      "+headingTxt);

        Assert.assertEquals(headingTxt,"Quia quis non","Heading Text doesn't match, dismiss test");
    }
}
