import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity5_2{
    public static void main(String[] args) throws InterruptedException {
        // Create a new instance of the Firefox driver

        System.setProperty("webdriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/dynamic-controls");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement isCheckBox = driver.findElement(By.xpath("//input[@class='willDisappear']"));
        System.out.println("CheckBox is selected before clicking on Remove button   :" + isCheckBox.isSelected());

        isCheckBox.click();
        System.out.println("Checkbox is selected");


        System.out.println("CheckBox is selected after clicking on Remove button   :" +isCheckBox.isSelected());

        driver.quit();
    }
}
