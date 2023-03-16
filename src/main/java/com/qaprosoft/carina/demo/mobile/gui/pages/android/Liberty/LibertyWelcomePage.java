package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LibertyWelcomePageBase.class)
public class LibertyWelcomePage extends LibertyWelcomePageBase {

    @FindBy(id = "layout_container")
    private ExtendedWebElement title;

    @FindBy(id = "btn_primary_button")
    private ExtendedWebElement addAccount;

    public LibertyWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return addAccount.isElementPresent();
    }

    @Override
    public LoginPage clickNextBtn() {
        addAccount.click();
        return initPage(getDriver(), LoginPage.class);
    }

}
