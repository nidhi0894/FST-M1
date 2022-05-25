import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class Activity12_2 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/nested-iframes");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);
        Assert.assertEquals(title,"Nested Iframes","Title doesn't match");

        //main iFrame
        driver.switchTo().frame(0);
        System.out.println("Focus is switched to main iframe or outer iframe");

        //1st frame
        driver.switchTo().frame(0);
        WebElement frame1 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of First iframe:  "+frame1.getText());

        driver.switchTo().defaultContent();
        System.out.println("Focus is switched to default");


        //main iFrame
        driver.switchTo().frame(0);
        System.out.println("Focus is switched to main iframe or outer iframe");
        //2nd frame
        driver.switchTo().frame(1);
        WebElement frame2 = driver.findElement(By.cssSelector("div.content"));
        System.out.println("Heading of Second iframe:  "+frame2.getText());

        driver.switchTo().defaultContent();
        System.out.println("Focus is switched to default");


        driver.quit();
    }
}
