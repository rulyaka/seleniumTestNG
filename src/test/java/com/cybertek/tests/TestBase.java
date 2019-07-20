package com.cybertek.tests;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

       protected WebDriver driver;
       protected Actions actions;
       protected WebDriverWait wait;

    @BeforeClass
    public void setUpMethod() throws InterruptedException {
        driver = Driver.get();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        actions = new Actions(driver);

        driver.get(ConfigurationReader.get("url"));

    }

    @AfterClass
    public void tearDownMethod(){
        Driver.closeDriver();
    }


}
