package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.*;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReadExcelExample {
    // takes the file path and creates connection to the file
    private FileInputStream fileInputStream;

    // represents the excel file
    private Workbook workbook;

    // represents a single sheet from excel file
    private Sheet workSheet;

    @BeforeMethod
    public void setUp() throws IOException {
        // location the excel file
        String filePath = "src/test/resources/Countries.xlsx";
        // create input stream from using the file path
        fileInputStream = new FileInputStream(filePath);
        // create the workbook object
        workbook = WorkbookFactory.create(fileInputStream);
        // create a worksheet, get the work sheet by its 0 based index
//        workSheet = workbook.getSheetAt(2);
        // returns the sheet by its name
        workSheet = workbook.getSheet("Countries");

    }

    @AfterMethod
    public void tearDown() throws IOException {
        workbook.close();
        fileInputStream.close();
    }

    @Test
    public void readName() {
        // getSheetName --> returns the name of the current sheet
        String sheetName = workSheet.getSheetName();
        System.out.println("sheetName = " + sheetName);

        // getLastRowNum --> returns the last row number
        // 0 based count
        int rowCount = workSheet.getLastRowNum();
        System.out.println("rowCount = " + rowCount);

        // getRow(0) --> get the first row
        // getLastCellNum  -> index of the last cell (NOT zero based)
        int colCount = workSheet.getRow(0).getLastCellNum();
        System.out.println("colCount = " + colCount);
    }

    @Test
    public void readSingleCell() {
        // first select the row
        // Row --> represents a single row
        // getRow  --> get rows from the sheet, 0 based
        Row row = workSheet.getRow(6);

        // select certain cell from the row
        // Cell --> represents a single cell
        // row.getCell --> returns single cell, 0 based
        Cell cell = row.getCell(0);

        // get the value of the cell as string
        String value = cell.toString();
        System.out.println("value = " + value);
    }

    @Test
    public void readAllValues() {
        // get the last row num
        int numberOfRows = workSheet.getLastRowNum();

        // iterate through all the rows
        for (int i = 0; i <= numberOfRows; i++) {
            // get each row using the i as row number
            Row currentRow = workSheet.getRow(i);
            // get the string value of the first cell in this row
            String cell1Value = currentRow.getCell(0).toString();
            String cell2Value = currentRow.getCell(1).toString();

            System.out.println(cell1Value + " " + cell2Value);
        }

    }

    @Test
    public void tableToMap() {
        // convert the  our table to Map<String, String>
        int rowCount = workSheet.getLastRowNum();

        Map<String, String> countryMap = new HashMap<>();
        for (int i = 1; i <= rowCount; i++) {
            Row currentRow = workSheet.getRow(i);
            String country = currentRow.getCell(0).toString();
            String capital = currentRow.getCell(1).toString();
            countryMap.put(country, capital);
        }
        System.out.println(countryMap);

        String capitalOfTajikistan = countryMap.get("Tajikistan");
        System.out.println("Capital of Tajikistan = " + capitalOfTajikistan);

    }

    @Test
    public void tableToListOfMaps() {
        // convert the  our table to List<Map<String, String>>
        int rowCount = workSheet.getLastRowNum();

        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 1; i <= rowCount; i++) {
            Map<String, String> map = new HashMap<>();
            Row currentRow = workSheet.getRow(i);
            String country = currentRow.getCell(0).toString();
            String capital = currentRow.getCell(1).toString();
            map.put("Country", country);
            map.put("Capital", capital);

            list.add(map);
        }
        System.out.println(list);
        System.out.println(list.get(5));
        System.out.println(list.get(5).get("Country"));


    }

}







