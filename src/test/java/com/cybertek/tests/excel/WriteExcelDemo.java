package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelDemo {

    @Test
    public void writeExcelDemo() throws IOException {
        FileInputStream fileInputStream =
                new FileInputStream("src/test/resources/Countries.xlsx");
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet workSheet = workbook.getSheet("Countries");

        // get the first row (getRow(0)) then the 3rd cell getCell(2)
        Cell colName = workSheet.getRow(0).getCell(2);

        if (colName == null) {
            // createCell  --> creates a cell in the worksheet in the given index.
            // if cell is null we cannot write to it. we need to call create first
            colName = workSheet.getRow(0).createCell(2);
        }
        // sets the value of the cell to give string
        colName.setCellValue("Result");

        // class is used to open file and write to it
        FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/Countries.xlsx");
        // write the changes to the file and save
        workbook.write(fileOutputStream);


        // close connections
        workbook.close();
        fileOutputStream.close();
        fileInputStream.close();

    }
}
