package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CalendarPageBase extends AbstractPage {
    public CalendarPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract String getMonth();
}
