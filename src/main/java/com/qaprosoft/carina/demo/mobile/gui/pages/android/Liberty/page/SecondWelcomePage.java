package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.page;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.SecondWelcomePageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SecondWelcomePage extends SecondWelcomePageBase {

    @FindBy(id = "org.rferl.by:id/fragment_notifications_title")
    private ExtendedWebElement title;

    @FindBy(id = "org.rferl.by:id/fragment_notifications_next")
    private ExtendedWebElement next;

    public SecondWelcomePage(WebDriver driver) {
        super(driver);
    }
}
