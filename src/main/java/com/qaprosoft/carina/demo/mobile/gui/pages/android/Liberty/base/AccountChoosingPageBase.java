package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AccountChoosingPageBase extends AbstractPage {
    public AccountChoosingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PolicyPageBase choose(String email);
}
