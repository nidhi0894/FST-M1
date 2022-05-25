package jobBoard.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
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
    public void VerifyHeading(){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebElement heading = driver.findElement(By.xpath("//h1[@class='entry-title']"));
        System.out.println("Heading:      "+heading.getText());

        Assert.assertEquals(heading.getText(),"Welcome to Alchemy Jobs","Heading text doesn't match, dismiss test!!!");
    }
}
