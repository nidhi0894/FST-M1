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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;

public class Activity9 {
    WebDriver driver;
    WebDriverWait wait;
    @BeforeMethod
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://alchemy.hguy.co/jobs/wp-admin");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
    @AfterMethod
    public void TearDown(){
        driver.quit();
    }

    @DataProvider(name = "Authentication")
    public static Object[][] credentials() {
        return new Object[][] {
                { "root", "pa$$w0rd","DB Tester" },
        };
    }

    @Test(dataProvider = "Authentication")
    public void CreateJobListingBackEnd(String username, String password, String jobTitle){

        //Login to application
        String websiteTitle = driver.getTitle();
        System.out.println("Title:      "+websiteTitle);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user_login")));

        WebElement enterUsername = driver.findElement(By.id("user_login"));
        enterUsername.clear();
        enterUsername.sendKeys(username);

        WebElement enterPassword = driver.findElement(By.id("user_pass"));
        enterPassword.clear();
        enterPassword.sendKeys(password);

        driver.findElement(By.id("wp-submit")).click();

        String verifyLogin = driver.findElement(By.tagName("h1")).getText();
        Assert.assertEquals(verifyLogin,"Dashboard", "User login not verified");
        System.out.println("User logged in successfully");

        //Verify Dashboard page
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("h1")));

        WebElement header = driver.findElement(By.tagName("h1"));
        Assert.assertEquals(header.getText(),"Dashboard", "Title is not matched");

        //Clicking on Job Listings menu & Verify the page
        driver.findElement(By.xpath("//div[text()='Job Listings ']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Job Listings ']")));
        Assert.assertEquals(driver.getTitle(),"Jobs ‹ Alchemy Jobs — WordPress", "Title is not matched");

        //Clicking on Add new button
        driver.findElement(By.xpath("//a[@class='page-title-action']")).click();

        //close dialog box
        WebElement dialog = driver.findElement(By.xpath("//*[@role='dialog']"));
        if(dialog.isDisplayed()){
            driver.findElement(By.xpath("//button[@aria-label='Close dialog']"));
            System.out.println("Dialog is closed");
        }

        //Enter Job title and publish
        driver.findElement(By.xpath("//textarea[@class='editor-post-title__input']")).sendKeys(jobTitle);

        WebElement publishBtn = driver.findElement(By.xpath("//button[text()='Publish…']"));
        if(publishBtn.isDisplayed()){
            publishBtn.click();
        }

        WebElement publish2 = driver.findElement(By.xpath("//button[text()='Publish']"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Publish']")));
        if(publish2.isDisplayed()){
            publish2.click();
        }

//        WebElement publishText = driver.findElement(By.xpath("//div[text()='Published']"));
//        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Published']")));
////        wait.until((ExpectedConditions.textToBePresentInElement(publishText,"Published")));
//        boolean verifyJobPublished = publishText.isDisplayed();
//        System.out.println("Job Published is displayed:   "+verifyJobPublished);

        //Verify Post published
//        WebElement postPublished = driver.findElement(By.xpath("//*[@class='components-snackbar__content']"));
//        WebElement postPublished = driver.findElement(By.xpath("//*[text()='Post published.']"));
//        wait.until((ExpectedConditions.visibilityOf(postPublished)));
//        Assert.assertEquals(postPublished.getText(),"Post published.","Job created...Verified successfully");

        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='View Job']")));
        driver.findElement(By.xpath("//a[text()='View Job']")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("main-navigation")));

        WebElement jobMenu = driver.findElement(By.xpath("//a[text()='Jobs']"));
        jobMenu.click();
        System.out.println("Jobs Page Title:      "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Jobs – Alchemy Jobs","Page Title doesn't match, dismiss test");

        driver.findElement(By.xpath("//input[@name='search_keywords']")).sendKeys(jobTitle);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@value='Search Jobs']")));
        driver.findElement(By.xpath("//input[@value='Search Jobs']")).click();
        System.out.println("Search jobs for "+jobTitle);

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@class='job_listings']/li")));
        WebElement verifyListing = driver.findElement(By.xpath("(//ul[@class='job_listings']/li)[1]"));
        String jobDisplayed = verifyListing.getText();
        System.out.println("Job displayed is:  "+jobDisplayed);


    }
}
