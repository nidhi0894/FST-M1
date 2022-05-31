package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

/*
In this activity we will be practicing with the Contacts app.
 */
public class Activity4 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void SetUp() throws MalformedURLException {

        //Appium device background details
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.contacts");
        caps.setCapability("appActivity", "com.android.contacts.activities.PeopleActivity");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appServer, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void addContact(){

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.contacts:id/floating_action_button")));

        driver.findElement(AppiumBy.accessibilityId("Create contact")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Create contact']")));

        driver.findElement(By.xpath("//android.widget.EditText[@text='First name']")).sendKeys("Aaditya");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Last name']")).sendKeys("Varma");
        driver.findElement(By.xpath("//android.widget.EditText[@text='Phone']")).sendKeys("999148292");

        driver.findElement(AppiumBy.id("com.google.android.contacts:id/toolbar_button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("/hierarchy/android.widget.Toast")));
//        WebElement toastMessage = driver.findElement(AppiumBy.xpath("/hierarchy/android.widget.Toast"));
//        System.out.println("Toast message displayed:  "+toastMessage.isDisplayed());
//        System.out.println("Toast Message text:  "+toastMessage.getText());

        WebElement contactName = driver.findElement(By.id("com.google.android.contacts:id/large_title"));
        System.out.println("Contact name displayed is:   "+contactName.getText());
        Assert.assertEquals(contactName.getText(),"Aaditya Varma","Name doesn't match");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
