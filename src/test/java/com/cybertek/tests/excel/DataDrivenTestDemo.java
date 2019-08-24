package com.cybertek.tests.excel;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.ExcelUtil;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataDrivenTestDemo extends TestBase {

    @Test
    public void testFullName(){
        extentLogger = report.createTest("Virify full names test");
        SoftAssert softAssert = new SoftAssert();
        // prepare my test data
        ExcelUtil qa3Sheet = new ExcelUtil("src/test/resources/Vytrack testusers.xlsx", "QA3-short");

        for (int i = 1; i < qa3Sheet.rowCount(); i++) {
            // only execute the tests which have y in column 1
            String execute = qa3Sheet.getCellData(i, 0);
            if (execute.equals("y")) {
                String username = qa3Sheet.getCellData(i, 1);
                String password = qa3Sheet.getCellData(i, 2);
                System.out.println("username = " + username);
                System.out.println("password = " + password);
                // login

                driver.get(ConfigurationReader.get("url"));
                LoginPage loginPage = new LoginPage();
                loginPage.login(username, password);
                // verify name
                DashboardPage dashboardPage = new DashboardPage();
                String fName = qa3Sheet.getCellData(i, 3);
                String lName = qa3Sheet.getCellData(i, 4);
                String expectedFullName = fName + " " + lName;
                System.out.println("expectedFullName = " + expectedFullName);
                String actualFullName = dashboardPage.userFullName.getText();
                System.out.println("actualFullName = " + actualFullName);
                // if values match
                if (actualFullName.equals(expectedFullName)) {
                    // write pass to the result column of the same row
                    qa3Sheet.setCellData("pass", "result", i);
                } else {
                    // write fail to the result column of the same row
                    qa3Sheet.setCellData("fail", "result", i);
                }
                softAssert.assertEquals(actualFullName, expectedFullName);
                // log out
                dashboardPage.logOut();
            } else {
                // write skip to the result column of the same row
                qa3Sheet.setCellData("skip", "result", i);

            }
        }
        softAssert.assertAll();
    }
}
