import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_1 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/javascript-alerts");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        driver.findElement(By.xpath("//button[@id='simple']")).click();
        String simpleAlertText = driver.switchTo().alert().getText();
        System.out.println("Simple alert text:   "+simpleAlertText);
        driver.switchTo().alert().accept();

        driver.quit();




    }
}