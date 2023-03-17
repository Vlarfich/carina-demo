package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.SideBarPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = SideBarPageBase.class)
public class SideBarPage extends SideBarPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/drawer_header_summary")
    private ExtendedWebElement summary;

    public SideBarPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return summary.isElementPresent();
    }

}
