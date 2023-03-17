package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.AccountChoosingPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.LoginPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LoginPageBase.class)
public class LoginPage extends LoginPageBase {

    @FindBy(id = "accounts_type_iv")
    private ExtendedWebElement title;

    @FindBy(id = "btn_add_google_account")
    private ExtendedWebElement addGoogle;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

   
    @Override
    public AccountChoosingPageBase clickAddAccountButton() {
        addGoogle.clickIfPresent();
        return initPage(getDriver(), AccountChoosingPageBase.class);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }


}

