import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_1 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/input-events");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement currentSide = driver.findElement(By.className("active"));
        //Left Click
        currentSide.click();

        String currentSideTxt = driver.findElement(By.xpath("//div[@id='D3Cube']/div[@class='active']")).getText();
        System.out.println("Current Side displayed after left click:    "+currentSideTxt);

        //Double click
        Actions action = new Actions(driver);
        action.moveToElement(currentSide).doubleClick().build().perform();
        System.out.println("Current Side displayed after double click:    "+currentSideTxt);

        //Right Click
        action.contextClick(currentSide).build().perform();
        System.out.println("Current Side displayed after right click:    "+currentSideTxt);


    driver.quit();

    }
}
