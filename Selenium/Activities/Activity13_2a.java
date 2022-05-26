import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.sun.org.apache.bcel.internal.classfile.ElementValue.STRING;
import static java.sql.Types.NUMERIC;

public class Activity13_2a {
    public static void main(String [] args) throws IOException {

        //Prepare the path of excel file
        String filePath = "src/test/sample.xlsx";

        //Create an object of current class
        Activity13_2a objFile = new Activity13_2a();

        //Write the file using file name, sheet name and the data to be filled
        objFile.writeExcel(filePath);

        //Call read file method of the class to read data
        objFile.readExcel(filePath);

    }
    public void writeExcel(String filePath) throws IOException {

        //Blank workbook
        XSSFWorkbook workbook = new XSSFWorkbook();

        //Creating a blank sheet
        XSSFSheet sheet = workbook.createSheet("Sheet1");

//        Creating data & Add it to the List
        List<String[]> data = new ArrayList<String[]>();
        String[] header = {"ID", "First Name", "Last Name", "Email", "Ph.No."};
        data.add(header);

        String[] r1 = {"1", "Satvik", "Shah", "satshah@example.com", "4537829158"};
        data.add(r1);

        String[] r2 = {"2", "Avinash", "Kati", "avinashK@example.com", "4892184058"};
        data.add(r2);

        String[] r3 = {"3", "Lahri", "Rath", "lahri.rath@example.com", "4528727830"};
        data.add(r3);

        //Iterate over data and write to sheet
        int rownum = 0;
        for (String[] rowData : data) {
            //Creates a new row in the sheet
            Row row = sheet.createRow(rownum++);
            int cellnum = 0;
            for (String cellData : rowData) {
                //Creates a cell in the next column of that row
                Cell cell = row.createCell(cellnum++);
                cell.setCellValue(cellData);
            }
        }

//        Writes to the workbook
        try {

            FileOutputStream out = new FileOutputStream(new File(filePath));
            workbook.write(out);
            out.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void readExcel(String filePath){
        try {
            FileInputStream file = new FileInputStream(filePath);

            //Create Workbook instance holding reference to Excel file
            XSSFWorkbook workbook = new XSSFWorkbook(file);

            //Get first sheet from the workbook
            XSSFSheet sheet = workbook.getSheetAt(0);

            //Iterate through each rows one by one
            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                //For each row, iterate through all the columns
                Iterator<Cell> cellIterator = row.cellIterator();

                while (cellIterator.hasNext()) {
                    Cell cell = cellIterator.next();
                    //Check the cell type and format accordingly
                    if(cell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC){
                        System.out.print(cell.getNumericCellValue() + " \t ");
                    } else if (cell.getCellType() == HSSFCell.CELL_TYPE_STRING) {
                        System.out.print(cell.getStringCellValue() + " \t ");
                    }else{
                        System.out.println("Invalid value");
                    }


//                    switch (cell.getCellType()) {
//                        case NUMERIC:
//                            System.out.print(cell.getNumericCellValue() + " \t ");
//                            break;
//                        case STRING:
//                            System.out.print(cell.getStringCellValue() + " \t ");
//                            break;
//                        default:
//                            System.out.println("Invalid value");
//                            break;
//                    }
                }
                System.out.println("");
            }
            file.close();
            workbook.close();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}

