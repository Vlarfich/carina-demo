package com.qaprosoft.carina.demo.web.krossby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Shoe extends AbstractUIObject {

    @FindBy(xpath = ".//h4//a")
    private ExtendedWebElement shoeModel;

    @FindBy(xpath = ".//p[contains(@class, 'price')]")
    private ExtendedWebElement shoePrice;

    public Shoe(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShoePrice(){
        return shoePrice.getText();
    }

    public String getShoeModel(){
        return shoeModel.getText();
    }

    public String toString(){
        return getShoeModel() + " : " + getShoePrice();
    }
}
