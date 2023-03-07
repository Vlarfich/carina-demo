package com.qaprosoft.carina.demo.web.krossby.Models;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.krossby.Pages.CheckOutPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.QuickView;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.Objects;

public class Shoe extends AbstractUIObject {

    @FindBy(xpath = ".//h4//a")
    private ExtendedWebElement shoeModel;

    @FindBy(xpath = ".//p[contains(@class, 'price')]")
    private ExtendedWebElement shoePrice;

    @FindBy(xpath = ".//button[contains(@type, 'button')]")
    private ExtendedWebElement viewButton;

    @FindBy(xpath = "//div[contains(@class, 'col-sm-6 product-center clearfix')]")
    private QuickView quickView;


    public Shoe(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getShoePrice() {
        return shoePrice.getText();
    }

    public int getPrice() {
        String str = StringUtils.remove(getShoePrice(), "BYN");
        str = StringUtils.remove(str, " ");
        str = StringUtils.substringBefore(str, "\n");
        return Integer.parseInt(str);
    }

    public String getShoeModel() {
        return shoeModel.getText();
    }

    public String toString() {
        return getShoeModel() + " : " + getShoePrice();
    }


    public QuickView getQuickView() {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Shoe shoe = (Shoe) o;
        return Objects.equals(getShoeModel(), shoe.getShoeModel()) && Objects.equals(getShoePrice(), shoe.getShoePrice());
    }

    @Override
    public int hashCode() {
        return Objects.hash(shoeModel, shoePrice);
    }
}
