package com.cybertek.tests.excel;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ExcelUtil;
import org.testng.annotations.Test;

public class DataDrivenTestDemo extends TestBase {

    @Test
    public void testFullName() {
        // prepaer my test data
        ExcelUtil qa3Sheet = new ExcelUtil("C:\\Users\\Ruslan\\IdeaProjects\\va-spring-2019-selenium-testng\\target\\test-classes\\Vytrack testusers.xlsx", "QA3-Short");

        for (int i = 1; i < qa3Sheet.rowCount(); i++) {
            // only execute tests which  have y in column 1
            String execute = qa3Sheet.getCellData(i, 0);


            if (execute.equals("y")) {
            }
            System.out.println(qa3Sheet.getCellData(1, 1));
            String username = qa3Sheet.getCellData(i, 1);
            String password = qa3Sheet.getCellData(i, 2);
            System.out.println("username " + username);
            System.out.println("password " + password);

            LoginPage loginPage = new LoginPage();
            loginPage.login(username, password);

            DashboardPage dashboardpage = new DashboardPage();
            String fName = qa3Sheet.getCellData(i,3);
            String lName = qa3Sheet.getCellData(i,4);
            String expectedFullName = fName + " " + lName;
            System.out.println("expectedFullName "+expectedFullName);
            String actualFullName = dashboardpage.userFullName.getText();
            System.out.println("actualFullName "+actualFullName);
              


            //log out
            dashboardpage.logOut();
        }
    }

}
