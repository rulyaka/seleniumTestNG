package com.cybertek.tests.excel;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;

public class ExcelUtilDemo {

    @Test
    public void test(){
        // this utily open the excel based on given path and creates object which is used to work with the given sheet
        ExcelUtil qa3Sheet = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA3-short");
        // 1 based , not 0 based
        int rowCount = qa3Sheet.rowCount();
        // 1 based, not 0 based
        int colCount = qa3Sheet.columnCount();
        System.out.println("rowCount = " + rowCount);
        System.out.println("colCount = " + colCount);

        List<String> columnsNames = qa3Sheet.getColumnsNames();
        System.out.println("columnsNames = " + columnsNames);


    }


}
