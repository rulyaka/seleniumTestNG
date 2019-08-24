package com.cybertek.tests.excel;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class DataDrivenTestDemo extends TestBase {

    @Test
    public void testFullName(){
        // prepaer my test data
        ExcelUtil qa3Sheet = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx","Qa3-Sheet");

        for (int i = 1; i < qa3Sheet.rowCount(); i++) {
            // only execute tests which  have y in column 1
            String execute = qa3Sheet.getCellData(i,0);


            if(execute.equals("y")){}
            System.out.println(qa3Sheet.getCellData(1,1));
            String username= qa3Sheet.getCellData(i,1);
            String password = qa3Sheet.getCellData(i,2);
            System.out.println("username "+username);
            System.out.println("password "+password);
        }
    }

}
