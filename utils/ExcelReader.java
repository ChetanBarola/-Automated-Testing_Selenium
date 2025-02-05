package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
    public static FileInputStream file;
    public static XSSFWorkbook workbook;
    public static XSSFSheet sheet;
    public static XSSFRow row;
    public static XSSFCell col;
    public static int rowvalue;
    public static int colvalue;

    /*
        Method Name: readdata
        Author: Kirtik Biswas
        Description: Reads data from an excel file based on the provided file path, sheet name, row number and column number
        Return Type; String
        Parameters: String filepath, String sheetname, int rownumber, int colnumber
    */

    public static String readdata(String filepath, String sheetname, int rownumber, int colnumber) throws IOException{
        try{
            file = new FileInputStream(filepath);
            workbook = new XSSFWorkbook(file);
        }
        catch(Exception e){
            e.printStackTrace();
        }

        sheet = workbook.getSheet(sheetname);
        row = sheet.getRow(rownumber);
        col = row.getCell(colnumber);

        String value;

        try{
            DataFormatter d = new DataFormatter();
            value = d.formatCellValue(col);
            return value;
        }
        catch(Exception e){
            value = "";
        }
        workbook.close();
        file.close();
        return value;
    }
}
