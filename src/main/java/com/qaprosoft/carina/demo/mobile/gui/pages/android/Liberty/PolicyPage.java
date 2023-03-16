package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty;

import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PolicyPageBase.class)
public class PolicyPage extends PolicyPageBase{
    public PolicyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void allow() {

    }
}
