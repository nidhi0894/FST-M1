import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_2 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/tables");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        int colCount = driver.findElements(By.xpath("//table[@class='ui sortable celled table']/tbody/tr[1]/td")).size();
        System.out.println("Column Count:   "+colCount);

        int rowCount = driver.findElements(By.xpath("//table[@class='ui sortable celled table']/tbody/tr")).size();
        System.out.println("Row Count:   "+rowCount);

        WebElement Row2_Col2 = driver.findElement(By.xpath("//table[@class='ui sortable celled table']/tbody/tr[2]/td[2]"));
        System.out.println("Value at 2nd row 2nd col:  "+Row2_Col2.getText());

        driver.findElement(By.xpath("//th[text()='Name']")).click();
        System.out.println("Value at 2nd row 2nd col after clicking on Name header:  "+Row2_Col2.getText());



        driver.quit();
    }
}
