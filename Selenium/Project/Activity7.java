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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity7 {
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

    @DataProvider(name = "JobListing")
    public static Object[][] data() {
        return new Object[][] {
                { "rich@gmail.com","SDET2", "IBM", "https://www.ibm.com/in-en", "International Business Machines Corporation (IBM)","Visit company website","IBM Twitter" },
        };
    }

    @Test(dataProvider = "JobListing")
    public void CreateNewJobListing(String mail,String jobTitle,String c_name, String c_website, String c_tag, String c_video, String c_twitter){

        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-navigation")));

        WebElement postJobMenu = driver.findElement(By.xpath("//a[text()='Post a Job']"));
        postJobMenu.click();

        System.out.println("Post Jobs Page Title:      "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Post a Job – Alchemy Jobs","Page Title doesn't match, dismiss test");

        driver.findElement(By.xpath("//input[@name='create_account_email']")).sendKeys(mail);
        driver.findElement(By.xpath("//input[@name='job_title']")).sendKeys(jobTitle);

        driver.switchTo().frame(0);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("body")));
        driver.findElement(By.xpath("//body")).sendKeys("Job requirement");
        driver.switchTo().defaultContent();

        driver.findElement(By.id("application")).sendKeys(mail);

        WebElement companyDetails = driver.findElement(By.tagName("h2"));

        Actions act = new Actions(driver);
        act.moveToElement(companyDetails);

        driver.findElement(By.xpath("//input[@name='company_name']")).sendKeys(c_name);
        driver.findElement(By.xpath("//input[@name='company_website']")).sendKeys(c_website);
        driver.findElement(By.xpath("//input[@name='company_tagline']")).sendKeys(c_tag);
        driver.findElement(By.xpath("//input[@name='company_video']")).sendKeys(c_video);
        driver.findElement(By.xpath("//input[@name='company_twitter']")).sendKeys(c_twitter);
        driver.findElement(By.xpath("//input[@value='Preview']")).click();
        System.out.println("User has entered job listing details and clicked on Preview");

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@value='Submit Listing']")));
        driver.findElement(By.xpath("//input[@value='Submit Listing']")).click();
        System.out.println("User has submitted the listings");

        //
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-navigation")));
        WebElement jobMenu = driver.findElement(By.xpath("//a[text()='Jobs']"));
        jobMenu.click();

        System.out.println("Jobs Page Title:      "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Jobs – Alchemy Jobs","Page Title doesn't match, dismiss test");

        driver.findElement(By.xpath("//input[@name='search_keywords']")).sendKeys(jobTitle);
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        System.out.println("Search jobs for "+jobTitle);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li")));
        WebElement verifyListing = driver.findElement(By.xpath("(//ul[@class='job_listings']/li)[1]"));
        String jobDisplayed = verifyListing.getText();
        System.out.println("Job displayed is:  "+jobDisplayed);


    }
}
