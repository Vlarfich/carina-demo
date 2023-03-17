package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.AccountChoosingPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.PolicyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountChoosingPageBase.class)
public class AccountChoosingPage extends AccountChoosingPageBase {

    @FindBy(id = "com.google.android.gms:id/main_title")
    private ExtendedWebElement title;

    @FindBy(id = "com.google.android.gms:id/account_name")
    private List<ExtendedWebElement> emails;

    public AccountChoosingPage(WebDriver driver) {
        super(driver);
    }

    public ExtendedWebElement getAccount(String email) {
        ExtendedWebElement res = null;
        for(ExtendedWebElement element : emails){
            if(element.getText().equals(email)){
                res = element;
                break;
            }
        }
        return res;
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public PolicyPageBase choose(String email) {
        getAccount(email).click();
        return initPage(getDriver(), PolicyPageBase.class);
    }

}
