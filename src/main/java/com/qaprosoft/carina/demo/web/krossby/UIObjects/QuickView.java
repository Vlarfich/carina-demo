package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.krossby.Pages.CheckOutPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class QuickView extends AbstractUIObject {

    @FindBy(xpath = "//label[contains(@class, 'radio')]")
    private ExtendedWebElement radio;

    @FindBy(id = "button-cart")
    private ExtendedWebElement cartButton;

    public QuickView(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public CheckOutPage buyWithoutChoosingSize(){
        cartButton.hover();
        cartButton.click();
        return new CheckOutPage(getDriver());
    }

    public void clickSize() {
        radio.click();
    }

    public CheckOutPage buyWithSize() {
        clickSize();
        cartButton.click();
        return new CheckOutPage(getDriver());
    }
}
