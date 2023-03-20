package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SideBarPageBase extends AbstractPage {
    public SideBarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getEmailName();

}