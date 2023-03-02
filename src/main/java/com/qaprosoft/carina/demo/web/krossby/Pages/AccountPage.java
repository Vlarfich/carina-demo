package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class AccountPage extends AbstractPage {

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(id = "top-links")
    private Header header;

    public AccountPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://kross.by/my-account/");
    }
}
