package com.cybertek.tests.page_object_model_tests;

import com.cybertek.pages.LoginPage;
import com.cybertek.tests.TestBase;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import sun.rmi.runtime.Log;

public class PositiveLoginTests extends TestBase {


    @BeforeMethod
    public void setUpMethod2() {
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void loginDriverTest() {
        String username = ConfigurationReader.get("driver_username");
        String password = ConfigurationReader.get("driver_password");

        LoginPage loginPage = new LoginPage();

        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();

        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

    @Test
    public void loginSalesManager() {
        LoginPage loginPage = new LoginPage();

        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");
        loginPage.login(username, password);

        BrowserUtils.waitFor(2);
        Assert.assertTrue(driver.getTitle().contains("Dashboard"));
    }

}









