package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.*;
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

            // get the last row number (0 based)
        int rowsCount = workSheet.getLastRowNum();
        System.out.println("rowsCount = " + rowsCount);
        // for loot to iterate through all the rows, skip the 1st row
        for (int i = 1; i <=rowsCount ; i++) {
            // current row where want to vhange result
            Row currentRow = workSheet.getRow(i);
            // result cell
            Cell cell = currentRow.getCell(2);
            if (cell == null) {
                cell = currentRow.createCell(2);
            }
            cell.setCellValue("PASS");

        }

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
