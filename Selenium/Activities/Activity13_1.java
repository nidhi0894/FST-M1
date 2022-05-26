import com.opencsv.CSVReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class Activity13_1 {
    public static void main(String[] args) throws IOException {

        CSVReader file = new CSVReader(new FileReader("src/test/TestCSV.csv"));
//        CSVReader file = new CSVReader(new FileReader(System.getProperty("user.dir")+"src/test/TestCSV.csv"));

//        Saving file data in list
        List<String[]> list = file.readAll();
        System.out.println("Total number of rows are: " + list.size());

//        Creating Iterator reference
        Iterator<String[]> itera = list.iterator();

//        Iterating through values
        while(itera.hasNext()){
            String[] str = itera.next();

            System.out.print("Values are: ");
            for(int i=0;i<str.length;i++) {
                System.out.print(" " + str[i]);
            }
            System.out.println(" ");
        }
        file.close();
    }
}
