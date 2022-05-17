import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_3 {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver

        System.setProperty("webdriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement textArea = driver.findElement(By.id("dynamicText"));
        System.out.println("Input field is enabled before  :" + textArea.isEnabled());

        driver.findElement(By.id("toggleInput")).click();
        System.out.println("Enable input button is clicked");


        System.out.println("Input field is enabled after   :" +textArea.isEnabled());

        driver.quit();
    }
}
