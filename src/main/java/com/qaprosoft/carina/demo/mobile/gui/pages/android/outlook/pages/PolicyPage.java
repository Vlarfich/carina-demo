package com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.AddAnotherAccountPageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.PolicyPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = PolicyPageBase.class)
public class PolicyPage extends PolicyPageBase implements IMobileUtils {


    @FindBy(xpath = "/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.widget.RelativeLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View[4]/android.view.View/android.widget.Button")
    private ExtendedWebElement allow;

    @FindBy(id = "android:id/content")
    private ExtendedWebElement container;

    public PolicyPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return container.isElementPresent();
    }

    @Override
    public AddAnotherAccountPageBase allow() {
        Assert.assertTrue(swipeToAllowButton(), "Allow button not found");
        allow.click();
        return initPage(getDriver(), AddAnotherAccountPageBase.class);
    }

    public boolean swipeToAllowButton() {
        return swipe(allow, container);
    }
}
