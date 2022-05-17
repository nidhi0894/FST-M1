import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_2 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/input-events");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        Actions action = new Actions(driver);
        action.sendKeys("N").build().perform();

        WebElement inputKey = driver.findElement(By.id("keyPressed"));
        System.out.println(inputKey.getText()+" -  Key is pressed");

//        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").release().build().perform();

        action.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).build().perform();
        System.out.println(inputKey.getText()+" -  Key is pressed");

        driver.quit();

    }
}
