package activities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity5 {
    WebDriver driver;
    @BeforeMethod(alwaysRun = true)
    public void SetUp(){
        driver = new FirefoxDriver();
        driver.get("https://www.training-support.net/selenium/target-practice");
    }

    @AfterMethod(alwaysRun = true)
    public void TearDown(){
        driver.quit();
    }

    @Test(groups = {"HeaderTests", "ButtonTests"})
    public void VerifyTitle() {

        String title = driver.getTitle();
        System.out.println("Title:      " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Target Practice", "Title is not verified!!");
    }

    @Test(dependsOnMethods = {"VerifyTitle"}, groups = {"HeaderTests"})
    public void HeaderTest1() {

        WebElement header3 = driver.findElement(By.tagName("h3"));
        System.out.println("Header 3 text:   " + header3.getText());
        Assert.assertEquals(header3.getText(), "Third header", "Header Text Mismatch");
    }

    @Test(dependsOnMethods = {"VerifyTitle"}, groups = {"HeaderTests"})
    public void HeaderTest2(){
        WebElement header5 = driver.findElement(By.tagName("h5"));
        String getColour = header5.getCssValue("color");
        System.out.println("Header 5 colour:   "+getColour);
        Assert.assertEquals(getColour,"rgb(33, 186, 69)","Colour doesn't match");
    }

    @Test(dependsOnMethods = {"VerifyTitle"}, groups = {"ButtonTests"})
    public  void ButtonTest1(){

        WebElement oliveBtn = driver.findElement(By.xpath("//button[contains(@class,'olive')]"));
        System.out.println("Button text:   "+oliveBtn.getText());
        Assert.assertEquals(oliveBtn.getText(),"Olive","Button color doesn't match");
    }

    @Test(dependsOnMethods = {"VerifyTitle"}, groups = {"ButtonTests"})
    public  void ButtonTest2(){

        WebElement brownBtn = driver.findElement(By.cssSelector("button.brown"));
        String color = brownBtn.getCssValue("color");
        Assert.assertEquals(color, "rgb(255, 255, 255)","Button color doesn't match");

    }
}
