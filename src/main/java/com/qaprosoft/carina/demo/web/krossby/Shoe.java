package com.qaprosoft.carina.demo.web.krossby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.krossby.Pages.CheckOutPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.QuickView;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Shoe extends AbstractUIObject {

    @FindBy(xpath = ".//h4//a")
    private ExtendedWebElement shoeModel;

    @FindBy(xpath = ".//p[contains(@class, 'price')]")
    private ExtendedWebElement shoePrice;

    @FindBy(xpath = ".//button[contains(@type, 'button')]")
    private ExtendedWebElement viewButton;

    @FindBy(xpath = ".//div[contains(@class, 'col-sm-6 product-center clearfix')]")
    private QuickView quickView;



    public Shoe(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShoePrice() {
        return shoePrice.getText();
    }

    public int getPrice() {
        String first = getShoePrice().split(" ", 2)[0];
        return Integer.parseInt(first);
    }

    public String getShoeModel() {
        return shoeModel.getText();
    }

    public String toString() {
        return getShoeModel() + " : " + getShoePrice();
    }


    public QuickView getQuickView(){
        shoeModel.hover();
        viewButton.click();
        return quickView;
    }

    public CheckOutPage buyNoSize() {
        shoeModel.hover();
        viewButton.click();
        return quickView.buyWithoutChoosingSize();
    }

    public CheckOutPage buyWithSize() {
        shoeModel.hover();
        viewButton.click();
        return quickView.buyWithSize();
    }

}
