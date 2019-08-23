package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.VytrackUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class NavigationBar {

    public NavigationBar(){
        PageFactory.initElements(Driver.get(), this);
    }
    @FindBy(css = "#user-menu>a")
    public WebElement userFullName;

    @FindBy(linkText = "Logout")
    public WebElement logOutLink;

    @FindBy(linkText = "My User")
    public WebElement myUser;

    public WebElement getTab(String tab) {
        String tabXpath = "//span[@class='title title-level-1' and contains(text(), '" + tab + "')]";
        return Driver.get().findElement(By.xpath(tabXpath));
    }

    public WebElement getModule(String module) {
        String moduleXpath = "//span[@class='title title-level-2' and contains(text(), '" + module + "')]";
        return Driver.get().findElement(By.xpath(moduleXpath));
    }

    public void selectMenuOption(String tab, String module) {
        WebElement tabEl = getTab(tab);
        BrowserUtils.hover(tabEl);

        WebElement moduleEl = getModule(module);
        BrowserUtils.waitForClickablility(moduleEl, 5).click();

        WebDriverWait wait = new WebDriverWait(Driver.get(), 5);
        if (module.equals("Vehicles")) {
            module = "Car";
        }
        wait.until(ExpectedConditions.titleContains(module));

    }


    public void logOut(){
        BrowserUtils.waitFor(2);
        BrowserUtils.clickWithJS(userFullName);
        BrowserUtils.clickWithJS(logOutLink);
    }
    public void goToMyUser(){
        VytrackUtils.waitForUIOverlay();
        BrowserUtils.waitForClickablility(userFullName, 5).click();
        BrowserUtils.waitForClickablility(myUser, 5).click();

    }
}
