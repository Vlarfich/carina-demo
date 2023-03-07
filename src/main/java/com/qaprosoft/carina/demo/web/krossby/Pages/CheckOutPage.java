package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.CartObject;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CheckOutPage extends AbstractPage {

    @FindBy(id = "simplecheckout_customer")
    private ExtendedWebElement checkoutBlock;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(xpath = "//span[contains(@data-hover, 'Каталог')]")
    private ExtendedWebElement catalog;

    @FindBy(id = "cart-total")
    private CartObject cartObject;

    public CheckOutPage(WebDriver driver) {
        super(driver);
        //setPageAbsoluteURL("https://kross.by/simplecheckout/");
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setUiLoadedMarker(checkoutBlock);
    }

    public CatalogPage clickCatalog() {
        return navigation.goToCatalog();
    }

    public String getText() {
        return cartObject.getText();
    }

    public int getTotal() {
        return cartObject.getTotal();
    }

    public int getAmount() {
        return cartObject.getAmount();
    }

    public String getTotalText() {
        return cartObject.getTotalText();
    }
}
