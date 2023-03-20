package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.WelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = WelcomePageBase.class)
public class WelcomePage extends WelcomePageBase {

    @FindBy(id = "layout_container")
    private ExtendedWebElement title;

    @FindBy(id = "btn_primary_button")
    private ExtendedWebElement addAccount;

    public WelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return addAccount.isElementPresent();
    }

    @Override
    public LoginPageBase clickNextBtn() {
        addAccount.click();
        return initPage(getDriver(), LoginPageBase.class);
    }

}
