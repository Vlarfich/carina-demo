package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.CalendarPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.FeedPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.MailPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.SideBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MailPageBase.class)
public class MailPage extends MailPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/toolbar")
    private ExtendedWebElement title;

    @FindBy(id = "com.microsoft.office.outlook:id/account_button")
    private ExtendedWebElement sideBar;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Calendar']/android.widget.TextView")
    private ExtendedWebElement calendar;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc='Search']/android.widget.TextView")
    private ExtendedWebElement feed;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public boolean clickSideBar() {
        return sideBar.clickIfPresent();
    }

    public boolean clickCalendar() {
        return calendar.clickIfPresent();
    }

    public boolean clickFeed() {
        return feed.clickIfPresent();
    }

    public SideBarPageBase openSideBar() {
        Assert.assertTrue(clickSideBar(), "SideBar opening failed!");
        return initPage(getDriver(), SideBarPageBase.class);
    }

    public CalendarPageBase openCalendar() {
        Assert.assertTrue(clickCalendar(), "Calendar opening failed!");
        return initPage(getDriver(), CalendarPageBase.class);
    }

    public FeedPageBase openFeed() {
        Assert.assertTrue(clickFeed(), "Feed opening failed!");
        return initPage(getDriver(), FeedPageBase.class);
    }

}
