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

public class Activity6 {
    WebDriver driver;
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/");
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @Test
    public void ApplyForJob(){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-navigation")));

        WebElement jobMenu = driver.findElement(By.xpath("//a[text()='Jobs']"));
        jobMenu.click();

        System.out.println("Jobs Page Title:      "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Jobs – Alchemy Jobs","Page Title doesn't match, dismiss test");

        String search = "Banking";
        driver.findElement(By.xpath("//input[@name='search_keywords']")).sendKeys(search);
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        System.out.println("Search jobs for "+search);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li")));

        int noOfJobListing = driver.findElements(By.xpath("//ul[@class='job_listings']/li")).size();
        System.out.println("There are -"+noOfJobListing+"- Job Listings");

        driver.findElement(By.xpath("(//ul[@class='job_listings']/li)[1]")).click();

        driver.findElement(By.xpath("//input[@type='button']")).click();

        String emailTo = driver.findElement(By.className("job_application_email")).getText();
        System.out.println("Email To:    "+emailTo);

    }
}
