package pageUtils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.Assert;

import java.io.FileInputStream;

/**
 * Created by saolin on 5/8/17.
 */
public class ExcelInputs {
    public static String readData(String className, int tcIndex, int tcValue) {

        String StringValue = null;
        try {

            FileInputStream file = new FileInputStream("f://Sample4.xlsx");
            XSSFWorkbook workbook=new XSSFWorkbook(file);

            Sheet sh= workbook.getSheet(className);
            Row row=sh.getRow(tcIndex);

            DataFormatter formatter = new DataFormatter(); //creating formatter using the default locale
            Cell cell = sh.getRow(tcIndex).getCell(tcValue);
            StringValue = formatter.formatCellValue(row.getCell(tcValue));

            System.out.println("Name : " + StringValue);



        } catch (Exception e) {
            Assert.fail("Exception in reading test data ", e);

        }
        return StringValue;
    }
}
