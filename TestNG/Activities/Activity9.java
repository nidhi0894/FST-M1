package activities;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

public class Activity9 {
    WebDriver driver;

    @BeforeTest
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        Reporter.log("Browser opened");
        String title = driver.getTitle();
        Reporter.log("Title:      "+driver.getTitle());
    }

    @BeforeMethod
    public void switchToDefault(){
        driver.switchTo().defaultContent();
        Reporter.log("Focus is switched to default");
    }

    @Test(priority = 0)
    public void simpleAlertTestCase(){

        driver.findElement(By.id("simple")).click();
        Alert alert1 = driver.switchTo().alert();
        Reporter.log("Simple alert text:"+alert1.getText());
        Assert.assertEquals(alert1.getText(),"This is a JavaScript Alert!","Alert text mismatched");
        alert1.accept();
        Reporter.log("Simple alert is accepted, and closed ");
    }

    @Test(priority = 1)
    public void confirmAlertTestCase(){

        driver.findElement(By.id("confirm")).click();
        Alert alert2 = driver.switchTo().alert();
        Reporter.log("Confirm alert text:"+alert2.getText());
        Assert.assertEquals(alert2.getText(),"This is a JavaScript Confirmation!","Alert text mismatched");
        alert2.accept();
        Reporter.log("Confirm alert is accepted, and closed ");
    }

    @Test(priority = 2)
    public void promptAlertTestCase(){

        driver.findElement(By.id("prompt")).click();
        Alert alert3 = driver.switchTo().alert();

        Reporter.log("Prompt alert text:"+alert3.getText());
        Assert.assertEquals(alert3.getText(),"This is a JavaScript Prompt!","Alert text mismatched");
        alert3.sendKeys("This is prompt alert");
        Reporter.log("Value is entered in Prompt alert");
        alert3.accept();
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }

}
