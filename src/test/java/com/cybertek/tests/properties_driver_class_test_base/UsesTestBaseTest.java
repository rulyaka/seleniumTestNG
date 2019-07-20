package com.cybertek.tests.properties_driver_class_test_base;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class UsesTestBaseTest extends TestBase {

    @BeforeMethod
    public void setUpMethod(){
        driver = Driver.get();
    }

    @Test
    public void test() {
        driver.get("https://google.com");
        System.out.println(driver.getTitle());

    }

    @Test
    public void test2() {

        driver.get("https://amazon.com");
        System.out.println(driver.getTitle());

    }
}
