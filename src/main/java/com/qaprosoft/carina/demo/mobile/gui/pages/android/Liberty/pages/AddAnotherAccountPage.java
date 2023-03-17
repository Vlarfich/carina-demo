package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.AddAnotherAccountPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.MailPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AddAnotherAccountPageBase.class)
public class AddAnotherAccountPage extends AddAnotherAccountPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/toolbar")
    private ExtendedWebElement title;

    @FindBy(id = "com.microsoft.office.outlook:id/bottom_flow_navigation_start_button")
    private ExtendedWebElement later;

    public AddAnotherAccountPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return later.isElementPresent();
    }
    @Override
    public MailPageBase later() {
        later.click();
        return initPage(getDriver(), MailPageBase.class);
    }
}
