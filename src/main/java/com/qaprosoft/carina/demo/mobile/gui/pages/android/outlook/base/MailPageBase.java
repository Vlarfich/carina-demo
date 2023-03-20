package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MailPageBase extends AbstractPage {
    public MailPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract SideBarPageBase openSideBar();

    public abstract CalendarPageBase openCalendar();

    public abstract FeedPageBase openFeed();

}
