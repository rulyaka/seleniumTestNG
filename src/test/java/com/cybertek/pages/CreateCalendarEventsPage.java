package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CreateCalendarEventsPage {
    public CreateCalendarEventsPage() {
        PageFactory.initElements(Driver.get(), this);
    }

    @FindBy(css = "[id^='recurrence-repeat-view']")
    public WebElement repeat;

}
