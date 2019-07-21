package com.cybertek.tests.review2;

import com.cybertek.tests.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class WaitReviewTest extends TestBase {

    @Test
    public void implicitWaitTest(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/4");

        WebElement message = driver.findElement(By.id("finish"));

        System.out.println(message.getText());
    }


    @Test
    public void implicitWaitTest2(){
        driver.get("http://practice.cybertekschool.com/dynamic_loading/2");

        driver.findElement(By.tagName("button")).click();

        WebElement message = driver.findElement(By.id("finish"));

        System.out.println(message.getText());
    }




}
