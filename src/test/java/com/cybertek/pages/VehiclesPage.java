package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.support.PageFactory;

public class VehiclesPage extends NavigationBar {

    public VehiclesPage() {
        PageFactory.initElements(Driver.get(), this);

    }
}
