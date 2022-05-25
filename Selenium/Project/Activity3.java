package jobBoard.Activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity3 {
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
    public void VerifyHeaderImage(){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebElement img = driver.findElement(By.tagName("img"));

        boolean verifyPresenceImg = img.isDisplayed();
        System.out.println("Image is available:      "+verifyPresenceImg);

        if(verifyPresenceImg==true){
            String imgProperty = img.getAttribute("src");
            System.out.println("Image URL:      "+imgProperty);
        }
    }
}
