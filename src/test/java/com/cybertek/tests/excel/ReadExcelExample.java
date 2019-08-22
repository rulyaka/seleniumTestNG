package com.cybertek.tests.excel;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ReadExcelExample {
    // takes the file path and creates connection to the file
    private FileInputStream fileInputStream;

    // represents the excel file
    private Workbook workbook;

    // represents a single sheet from excel file
    private Sheet workSheet;

    @BeforeTest
    public void setUp() throws IOException {
        // location the excel file
        String filePath = "src/test/resources/Countries.xlsx";
        // create input stream from using the file path
        fileInputStream = new FileInputStream(filePath);
        // create the workbook object
        workbook = WorkbookFactory.create(fileInputStream);
        // create a worksheet, get the work sheet by its 0 based index
        workSheet = workbook.getSheetAt(0);


    }

    @Test
    public void readName(){
        String sheetName = workSheet.getSheetName();
        System.out.println("sheetName = " + sheetName);
    }

}
