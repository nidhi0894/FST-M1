package Activities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.checkerframework.checker.units.qual.A;
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
In this activity, we will be using the default SMS application to send a message to yourself
 */
public class Activity5 {
    AndroidDriver driver;
    WebDriverWait wait;
    @BeforeClass
    public void SetUp() throws MalformedURLException {

        //Appium device background details
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.google.android.apps.messaging");
        caps.setCapability("appActivity", ".ui.ConversationListActivity");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appServer, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void smsApplicationTest(){

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Start chat")));

        driver.findElement(AppiumBy.accessibilityId("Start chat")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.id("com.google.android.apps.messaging:id/toolbar")));

        driver.findElement(By.id("com.google.android.apps.messaging:id/recipient_text_view")).sendKeys("8982347545");
        driver.pressKey(new KeyEvent(AndroidKey.ENTER));

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.accessibilityId("Make a video call")));

        driver.findElement(By.xpath("//android.widget.EditText[@text='Text message']")).sendKeys("Hello from Appium");
        driver.findElement(AppiumBy.accessibilityId("Send SMS")).click();

//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(AppiumBy.accessibilityId("Sending"))));

        wait.until(ExpectedConditions.presenceOfElementLocated(AppiumBy.xpath("(//android.widget.TextView[@text='Hello from Appium'])[2]")));
        WebElement message = driver.findElement(By.xpath("(//android.widget.TextView[@text='Hello from Appium'])[2]"));
        System.out.println("Message displayed is:   "+message.getText());
        Assert.assertEquals(message.getText(),"Hello from Appium","Message doesn't match");
    }

    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
