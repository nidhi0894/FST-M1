import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Activity8_1 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/tables");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        int colCount = driver.findElements(By.xpath("//th[contains(text(), 'Git Repository')]/following::tr[1]/td")).size();
        System.out.println("Column Count:   "+colCount);

        int rowCount = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr")).size();
        System.out.println("Row Count:   "+rowCount);

        List<WebElement> rowThrid = driver.findElements(By.xpath("//table[@class='ui celled striped table']/tbody/tr[3]/td"));
        System.out.println("Third row cell values are: ");
        for(WebElement cell : rowThrid){
            System.out.println(cell.getText());
        }

        String Row2_Col2 = driver.findElement(By.xpath("//table[@class='ui celled striped table']/tbody/tr[2]/td[2]")).getText();
        System.out.println("Value at 2nd row 2nd col:  "+Row2_Col2);
        driver.quit();
    }
}
