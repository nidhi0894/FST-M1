import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ISelect;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Activity9_2 {
    public static void main(String[] args) {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("https://www.training-support.net/selenium/selects");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);

        WebElement selectedOptions = driver.findElement(By.xpath("//h3[@id='multi-value']"));
        
        WebElement multiSelect = driver.findElement(By.id("multi-select"));
        Select list = new Select(multiSelect);

        if(list.isMultiple()){
            //Select
            list.selectByVisibleText("Javascript");
            list.selectByValue("node");
            list.selectByIndex(4);
            list.selectByIndex(5);
            list.selectByIndex(6);
            System.out.println("Selected Options---"+selectedOptions.getText());
            
            //Deselect
            list.deselectByValue("node");
            list.deselectByIndex(7);
            System.out.println("Selected Options after deselection---"+selectedOptions.getText());

            //Getting all selected options
            List<WebElement> getSelectedOptions = list.getAllSelectedOptions();
            //Print all selected options
            for(WebElement selectedOption : getSelectedOptions) {
                System.out.println("Display Selected option: " + selectedOption.getText());
            }

            //Deselecting all options
            list.deselectAll();
            System.out.println("Selected options after deselect all action---"+selectedOptions.getText());
        }

        driver.quit();
    }
}
