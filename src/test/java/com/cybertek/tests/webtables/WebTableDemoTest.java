package com.cybertek.tests.webtables;

import com.cybertek.tests.TestBase;
import com.cybertek.utilities.ConfigurationReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;

public class WebTableDemoTest extends TestBase {

    @BeforeMethod
    public void setUpMethodGetThatSite(){
        driver.get(ConfigurationReader.get("url"));
    }

    @Test
    public void printTable(){


        WebElement table = driver.findElement(By.id("table1"));

        System.out.println(table.getText());
    }

    // headers

    @Test
    public void headersTest(){
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));

        headers.forEach((cell-> System.out.println(cell.getText())));
        System.out.println("headers.size() = " + headers.size());

    }

    // get table size
    @Test
    public void tableSizeTest(){
        // TODO number of columns
        List<WebElement> headers = driver.findElements(By.xpath("//table[@id='table1']//th"));
        System.out.println("Number of columns: " + headers.size());
        // TODO number row including headers

        List<WebElement> rowsWithHeaders = driver.findElements(By.xpath("//table[@id='table1']//tr"));
        System.out.println("Number of rows including headers: " + rowsWithHeaders.size());

        // TODO number row without headers
        List<WebElement> rowsWithOutHeaders = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));
        System.out.println("Number of rows withouth headers:" + rowsWithOutHeaders.size());

        // BREAK 8:04
    }
}
