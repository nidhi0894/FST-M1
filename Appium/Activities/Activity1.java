package Activities;
/*
to perform a multiplication operation between two numbers.
 */

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
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

public class Activity1 {
    AndroidDriver driver;
    WebDriverWait wait;

    @BeforeClass
    public void SetUp() throws MalformedURLException {

        //Appium device background details
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "<device name>");
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("appPackage", "com.coloros.calculator");
        caps.setCapability("appActivity", "com.android.calculator2.Calculator");
        caps.setCapability("noReset", true);

        //Appium server URL
        URL appServer = new URL("http://localhost:4723/wd/hub");
        driver = new AndroidDriver(appServer, caps);
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    @Test
    public void calculatorTest(){

        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.xpath("//android.widget.TextView[@text='Calculator']")));
        driver.findElement(By.id("com.coloros.calculator:id/digit_8")).click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("digit_3")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Equals\"]")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.coloros.calculator:id/result")));
        String result = driver.findElement(By.id("com.coloros.calculator:id/result")).getText();

        Assert.assertEquals(result, "24", "Multiplication result doesn't match");
    }
    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
