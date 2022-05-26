import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Activity13_2b {
    public static void main(String[] args) throws IOException {
        System.setProperty("webDriver.gecko.driver", "C://Users//0035G0744//Documents//FSTDrivers//geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.training-support.net/selenium/simple-form");
        String title = driver.getTitle();
        System.out.println("Title is:   " + title);
        Assert.assertEquals(title, "Simple Form", "Title doesn't match");

        String filePath = "src/test/sample.xlsx";
        

        //Create an object of current class
        Activity13_2b srcExcel = new Activity13_2b();
        List<List<String>> data = srcExcel.readExcel(filePath);
        List<String> row = data.get(2);

        WebElement firstName = driver.findElement(By.id("firstName"));
        firstName.sendKeys(row.get(1));
        WebElement lastName = driver.findElement(By.id("lastName"));
        lastName.sendKeys(row.get(2));
        WebElement email = driver.findElement(By.id("email"));
        email.sendKeys(row.get(3));
        WebElement number = driver.findElement(By.id("number"));
        number.sendKeys(row.get(4));
        WebElement textarea = driver.findElement(By.tagName("textarea"));
        textarea.sendKeys("Filling form");

        Actions action = new Actions(driver);
        WebElement Submitbtn = driver.findElement(By.xpath("//input[@type='submit']"));
        action.moveToElement(Submitbtn).pause(Duration.ofSeconds(3));
        Submitbtn.click();

        Alert alert = driver.switchTo().alert();
        System.out.println("Alert message:   "+alert.getText());

        alert.accept();
        driver.quit();
    }

    private List<List<String>> readExcel(String filePath) throws IOException {
        List<List<String>> data = new ArrayList<List<String>>();
        try{
            FileInputStream file = new FileInputStream(filePath);

            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                //Temp variable
                List<String> rowData = new ArrayList<String>();
                Row row = rowIterator.next();

                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    if(row.getLastCellNum() == 5) {
                        //Store row data
                        rowData.add(cell.getStringCellValue());
                    }
                }
                //Store row data in List
                data.add(rowData);
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
        e.printStackTrace();
    }
        return data;
}
}
