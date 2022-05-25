import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity12_1 {

    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/iframes");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);


        //Frame 1
        driver.switchTo().frame(0);
        WebElement frameH1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of First iframe:  "+frameH1.getText());

        WebElement frame1Btn = driver.findElement(By.cssSelector("button"));
        String beforeClickTxt = frame1Btn.getText();
        System.out.println("Frame 1 Button text:   "+beforeClickTxt);
        System.out.println("Frame 1 Button background color:  "+frame1Btn.getCssValue("background-color"));

        frame1Btn.click();
        String afterClickTxt = frame1Btn.getText();
        System.out.println("Frame 1 Button text after click:   "+afterClickTxt);
        System.out.println("Frame 1 Button background color after click:  "+frame1Btn.getCssValue("background-color"));

        Assert.assertNotEquals(beforeClickTxt,afterClickTxt);

        driver.switchTo().defaultContent();

        //Frame 2
        driver.switchTo().frame(1);
        WebElement frame2H = driver.findElement(By.cssSelector("div.content"));
        System.out.println(frame2H.getText());

        WebElement frame2Btn = driver.findElement(By.cssSelector("button"));
        String beforeClickBtn = frame2Btn.getText();
        System.out.println("Frame 2 Button text:   "+beforeClickBtn);
        System.out.println("Frame 2 Button background color:  "+frame2Btn.getCssValue("background-color"));

        Actions action = new Actions(driver);
        action.moveToElement(frame2Btn).build().perform();
        frame2Btn.click();
        String afterClickBtn = frame2Btn.getText();
        System.out.println("Frame 2 Button text after click:   "+afterClickBtn);
        System.out.println("Frame 2 Button background color after click:  "+frame2Btn.getCssValue("background-color"));

        Assert.assertNotEquals(beforeClickBtn,afterClickBtn);
        driver.switchTo().defaultContent();
        driver.quit();
    }
}
