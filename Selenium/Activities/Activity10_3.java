import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity10_3 {
    public static void main(String[] args){
        System.setProperty("webDriver.gecko.driver","C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/drag-drop");
        String title = driver.getTitle();
        System.out.println("Title is:   "+title);

        WebElement ball = driver.findElement(By.xpath("//img[@id='draggable']"));

        WebElement zone1 = driver.findElement(By.id("droppable"));

        Actions action = new Actions(driver);
        action.dragAndDrop(ball,zone1).build().perform();

        WebElement verifyDroppedZ1 = driver.findElement(By.xpath("//p[text()='Dropped!']"));
        System.out.println("Verify Drag & Drop action performed to zone1 successfully  :" +verifyDroppedZ1.getText() );

        WebElement zone2 = driver.findElement(By.id("dropzone2"));
        action.dragAndDrop(ball,zone2).build().perform();

        WebElement verifyDroppedZ2 = driver.findElement(By.xpath("(//p[text()='Dropped!'])[2]"));
        System.out.println("Verify Drag & Drop action performed from zone 1 to zone 2 successfully  :" +verifyDroppedZ2.getText() );

        driver.quit();
    }
}
