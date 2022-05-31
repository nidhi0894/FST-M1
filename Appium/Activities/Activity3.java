package Activities;
/*
In this activity we will be practicing with the Calculator app some more.
 */

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
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

public class Activity3 {

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
        WebElement digit5 = driver.findElement(By.id("digit_5"));
        WebElement equalsBtn = driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc=\"Equals\"]"));
        WebElement result = driver.findElement(By.id("com.coloros.calculator:id/result"));

        //Addition
        digit5.click();
        driver.findElement(AppiumBy.accessibilityId("Add")).click();
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_9")).click();
        equalsBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.coloros.calculator:id/result")));
        System.out.println("Addition of 5 & 9: "+result.getText());
        Assert.assertEquals(result.getText(), "14", "Addition result doesn't match");

        //Subtraction
        driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_1")).click();
        WebElement digit0 = driver.findElement(AppiumBy.id("com.coloros.calculator:id/digit_0"));
        digit0.click();
        driver.findElement(AppiumBy.accessibilityId("Subtract")).click();
        digit5.click();
        equalsBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.coloros.calculator:id/result")));
        System.out.println("Subtraction of 5 from 10: "+result.getText());
        Assert.assertEquals(result.getText(), "5", "Subtraction result doesn't match");

        //Multiplication
        digit5.click();
        driver.findElement(By.id("op_mul")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_1")).click();
        digit0.click();digit0.click();
        equalsBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.coloros.calculator:id/result")));
        System.out.println("Multiplication of 5 & 100: "+result.getText());
        Assert.assertEquals(result.getText(), "500", "Multiplication result doesn't match");

        //Division
        digit5.click();
        digit0.click();
        driver.findElement(AppiumBy.accessibilityId("Divide")).click();
        driver.findElement(By.id("com.coloros.calculator:id/digit_2")).click();
        equalsBtn.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("com.coloros.calculator:id/result")));
        System.out.println("Division of 50 by 2: "+result.getText());
        Assert.assertEquals(result.getText(), "25", "Subtraction result doesn't match");
    }
    @AfterClass
    public void TearDown(){
        driver.quit();

    }
}
