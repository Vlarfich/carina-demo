package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends AbstractPage {

    @FindBy(id = "simplecheckout_customer")
    private ExtendedWebElement checkoutBlock;


    public CheckOutPage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(checkoutBlock);
    }
}
