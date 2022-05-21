package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity10 {
    WebDriver driver;
    Actions builder;
    WebElement slider;
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        builder = new Actions(driver);
        driver.get("https://www.training-support.net/selenium/sliders");
        String title = driver.getTitle();
        System.out.println("Title:      " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Sliders", "Title is not verified!!");

    }

    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void middleValueTest() {

        slider = driver.findElement(By.id("slider"));
        slider.click();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Middle value of slider: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "50");
    }

    @Test
    public void maximumValueTest() {

        slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(75, 0).release().build().perform();
        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Maximum value of slider: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "100");
    }

    @Test
    public void minimumValueTest() {

        slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-75, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "0");
    }

    @Test
    public void percent30ValueTest() {

        slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(-30, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("30% Min value: " + volumeLevel);

        Assert.assertEquals(volumeLevel, "30");
    }

    @Test
    public void percent80ValueTest() {

        slider = driver.findElement(By.id("slider"));
        builder.clickAndHold(slider).moveByOffset(45, 0).release().build().perform();

        String volumeLevel = driver.findElement(By.cssSelector("span#value")).getText();
        Reporter.log("80% Min value: " + volumeLevel);
        Assert.assertEquals(volumeLevel, "81");
    }
}
