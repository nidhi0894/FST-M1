package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
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
import java.util.List;

/*
In this activity, we will be working with Google Chrome browser on the mobile device.
 */
public class Activity6 {
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
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        driver.get("https://www.training-support.net/selenium/lazy-loading");
    }

    @Test
    public void chromeTest(){


        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("//android.widget.TextView[@text='Elements that take time to appear!']")));
        String title = driver.findElement(AppiumBy.xpath("(//android.widget.TextView)[2]")).getText();

        //String title = driver.getTitle();
        System.out.println("Landing screen heading:   "+title);
        Assert.assertEquals(title, "Lazy Loading");

        //Count Images
        List<WebElement> imagesCount = driver.findElements(By.xpath("//android.view.View/android.view.View/android.widget.Image"));
        System.out.println("Number of images before helen's post: " +imagesCount.size());

        // Assertion before scrolling
        Assert.assertEquals(imagesCount.size(), 2);

        //Scroll till halens post
        String UiScrollable = "new UiScrollable(new UiSelector().scrollable(true))";
        driver.findElement(AppiumBy.androidUIAutomator(UiScrollable + ".scrollIntoView(new UiSelector().text(\"helen\"))"));

        wait.until(ExpectedConditions.visibilityOfElementLocated(AppiumBy.xpath("//android.widget.TextView[contains(@text, 'helen')]")));

        System.out.println("Number of images after helen's post: " +imagesCount.size());
        // Assertion after scrolling
        Assert.assertEquals(imagesCount.size(), 2);

    }

    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
