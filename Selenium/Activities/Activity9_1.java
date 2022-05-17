import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_1 {

    public static void main(String[] args){
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/selects");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement selectDD = driver.findElement(By.tagName("select"));

        Select list = new Select(selectDD);
        List<WebElement> options = list.getOptions();

        list.selectByVisibleText("Option 2");
        list.selectByIndex(3);
        list.selectByValue("4");

//        int size = options.size();
        System.out.println("Dropdown options are:  ");
        for(WebElement option : list.getOptions()){
            System.out.println(option.getText());
        }

        driver.quit();



    }
}
