package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.DashboardPage;
import com.cybertek.pages.LoginPage;
import com.cybertek.pages.VehiclesPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class VehiclesPageTests extends TestBase {

    @BeforeMethod
    public void setUpMethod2(){
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void testFirstHeaderOption(){
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        // creating a new page object and using
        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        // create and use object in the same line. object is not saved
        new DashboardPage().selectMenuOption("Fleet", "Vehicles");

        // verify that first col name is license plate
        String expectedCol = "LICENSE PLATE";

        VehiclesPage vehiclesPage = new VehiclesPage();
        WebElement firstColumn = vehiclesPage.gridHeaders.get(0);

        Assert.assertEquals(firstColumn.getText(), expectedCol);

    }
}
