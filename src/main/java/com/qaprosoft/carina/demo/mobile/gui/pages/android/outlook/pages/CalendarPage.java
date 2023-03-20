package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.CalendarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CalendarPageBase.class)
public class CalendarPage extends CalendarPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/calendar_month_title_button")
    private ExtendedWebElement monthElement;

    public CalendarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return monthElement.isElementPresent();
    }

    public String getMonth() {
        return monthElement.getText();
    }

}
