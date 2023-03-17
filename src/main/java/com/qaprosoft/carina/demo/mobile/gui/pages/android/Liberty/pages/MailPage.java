package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.MailPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.SideBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MailPageBase.class)
public class MailPage extends MailPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/toolbar")
    private ExtendedWebElement title;


    @FindBy(id = "com.microsoft.office.outlook:id/account_button")
    private ExtendedWebElement sideBar;

    public MailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }


    public SideBarPageBase openSideBar() {
        sideBar.click();
        return initPage(getDriver(), SideBarPageBase.class);
    }

}
