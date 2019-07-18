package com.cybertek.tests.jse_and_actions;

import com.cybertek.utilities.VerificationUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsTest {

    WebDriver driver;
    @BeforeMethod
    public void setUpMethod(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


    @Test
    public void hover() throws InterruptedException {
        // Actions class that enables advanced interactions
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/hovers");
        Thread.sleep(1000);


        WebElement element = driver.findElement(By.tagName("img"));
        // moveToElement()  --> move the mouse to given target
        // perform  --> triggers the action
        actions.moveToElement(element).perform();

        Assert.assertTrue(VerificationUtils.isElementDisplayed(
                driver, By.linkText("View profile")));

    }


    @Test
    public void hover2() throws InterruptedException {
        Actions actions = new Actions(driver);
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        Thread.sleep(1000);

        WebElement firstOne = driver.findElement(By.id("ui-id-3"));
        WebElement secondOne = driver.findElement(By.id("ui-id-4"));

        actions.moveToElement(firstOne).perform();
        Thread.sleep(1000);
        actions.moveToElement(secondOne).perform();

    }
}
