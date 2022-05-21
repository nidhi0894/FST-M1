package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity2 {
    WebDriver driver;

    @Test
    public void VerifyHomePageTitleTest(){
        String title = driver.getTitle();
        System.out.println("Title:      "+driver.getTitle());
        Assert.assertEquals(title,"Target Practice");
    }

    @Test()
    public void VerifyElementTest(){
        WebElement blackButton = driver.findElement(By.className("ui black button"));
        Assert.assertTrue(blackButton.isDisplayed());
        Assert.assertEquals(blackButton.getText(),"Black");
    }

    @Test(enabled = false)
    public void VerifySkipTest() {
        //This test will be ignored and not shown in the results
        System.out.println("Skipping the test by setting Enabled as False:      ");
    }

    @Test()
    public void VerifySkipExceptionTest() throws SkipException {
        //This test will be skipped but recognized by testng
        System.out.println("Skipping the test by throwing SkipException:      ");
    }

    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }
}
