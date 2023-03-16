package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PolicyPageBase extends AbstractPage {
    public PolicyPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void allow();
}
