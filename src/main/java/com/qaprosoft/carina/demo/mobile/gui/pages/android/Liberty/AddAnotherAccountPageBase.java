package com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AddAnotherAccountPageBase extends AbstractPage {
    public AddAnotherAccountPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract void later();
}
