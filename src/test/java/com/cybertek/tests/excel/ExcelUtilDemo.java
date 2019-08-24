package com.cybertek.tests.excel;

import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

import java.util.List;
import java.util.Map;

public class ExcelUtilDemo {
    @Test
    public void test(){
        //this util open the xcel based on given path and creates object which is used to work with the given shit
        ExcelUtil qa3Sheet = new ExcelUtil("Vytrack testusers.xlsx","Vytrack testusers");

       int rowcount = qa3Sheet.rowCount();
       List<String> columnNames = qa3Sheet.getColumnsNames();

        System.out.println("columnNames "+ columnNames);
        String cellData = qa3Sheet.getCellData(2,3);
        System.out.println("cellData "+cellData);

        List<Map<String, String>> dataList=qa3Sheet.getDataList();
        System.out.println(dataList.get(5).get("firstname"));


    }
}
