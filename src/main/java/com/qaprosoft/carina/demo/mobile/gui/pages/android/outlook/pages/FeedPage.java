package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.FeedPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = FeedPageBase.class)
public class FeedPage extends FeedPageBase {

    @FindBy(id = "com.microsoft.office.outlook:id/search_title")
    private ExtendedWebElement title;

    public FeedPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public String getTitleText() {
        return title.getText();
    }
}
