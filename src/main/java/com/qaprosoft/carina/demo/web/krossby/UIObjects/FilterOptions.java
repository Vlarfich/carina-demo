package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.Keys;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class FilterOptions extends AbstractUIObject {

    @FindBy(id = "mfilter-opts-price-min")
    private ExtendedWebElement minPrice;
    @FindBy(id = "mfilter-opts-price-max")
    private ExtendedWebElement maxPrice;


    public FilterOptions(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public void inputMaxPrice(int max) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(maxPrice.getElement()).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        maxPrice.type("" + max);
        minPrice.click();
    }

    public void inputMinPrice(int min) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement(minPrice.getElement()).doubleClick().click().sendKeys(Keys.BACK_SPACE).perform();
        minPrice.type("" + min);
        maxPrice.click();
    }


}
