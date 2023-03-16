package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = AccountChoosingPageBase.class)
public class AccountChoosingPage extends AccountChoosingPageBase {

    @FindBy(id = "account_name")
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


}
