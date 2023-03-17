package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PolicyPageBase extends AbstractPage {
    public PolicyPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract AddAnotherAccountPageBase allow();

}
