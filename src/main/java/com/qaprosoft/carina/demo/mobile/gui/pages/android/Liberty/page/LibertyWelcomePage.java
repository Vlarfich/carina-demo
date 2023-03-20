package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.LibertyWelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.SecondWelcomePageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = LibertyWelcomePageBase.class)
public class LibertyWelcomePage extends LibertyWelcomePageBase {

    @FindBy(id = "org.rferl.by:id/fragment_first_launch_title")
    private ExtendedWebElement title;

    @FindBy(id = "org.rferl.by:id/fragment_first_launch_get_started_button")
    private ExtendedWebElement launchButton;

    public LibertyWelcomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isPageOpened() {
        return title.isElementPresent();
    }

    public boolean clickLaunch() {
        return launchButton.clickIfPresent();
    }

    public String getTitleText() {
        return title.getText();
    }

    public SecondWelcomePageBase launch() {
        Assert.assertTrue(clickLaunch(), "Launch button failed!");
        return initPage(getDriver(), SecondWelcomePageBase.class);
    }
}
