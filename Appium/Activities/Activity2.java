package Activities;
/*
Locate the About Us button and click it.
 */

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

public class Activity2 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {

        //Appium device background details
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "NNINZDNB45BIGAJZ");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.android.chrome");
        caps.setCapability("appActivity", "com.google.android.apps.chrome.Main");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appServer, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void chrome(){

        driver.get("https://www.training-support.net/");

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("About Us")));
        String title = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Training Support']")).getText();

//        String title = driver.getTitle();
        System.out.println("Landing screen heading:   "+title);
        Assert.assertEquals(title, "Training Support");

        driver.findElement(AppiumBy.xpath("//android.view.View[@content-desc='About Us']/android.widget.TextView")).click();

        // Wait for new page to load
        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")));
        String aboutUsTitle = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='About Us']")).getText();
        System.out.println("Screen heading after About us is clicked:   "+aboutUsTitle);
        Assert.assertEquals(aboutUsTitle, "About Us");

    }

    @AfterClass
    public void TearDown(){

        driver.quit();
    }
}
