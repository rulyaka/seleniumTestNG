package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.VytrackUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VytrackTests extends TestBase {

    @Test
    public void changeMenu(){
        driver.get(ConfigurationReader.get("url"));
        String username = ConfigurationReader.get("salesmanager_username");
        String password = ConfigurationReader.get("salesmanager_password");

        VytrackUtils.login(driver, username, password);

        Assert.assertTrue(driver.getTitle().contains("Dashboard"),
                "Title message was wrong");

        VytrackUtils.selectMenuOption(driver, "Activities", "Calls");
        System.out.println(driver.getTitle());
        Assert.assertTrue(driver.getTitle().contains("Calls"),
                "Title message was wrong");

    }
}
