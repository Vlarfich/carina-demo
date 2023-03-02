package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.krossby.Pages.ManufacturerShoesPage;
import com.qaprosoft.carina.demo.web.krossby.Pages.SalesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Navigation extends AbstractUIObject {

    @FindBy(xpath = "//a[contains(@href, '../index.php?route=product/special')]")
    private ExtendedWebElement onSale;

    @FindBy(xpath = "//span[contains(@data-hove, 'Производители')]")
    private ExtendedWebElement manufacturers;

    public Navigation(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SalesPage goToSalesPage(){
        onSale.click();
        return new SalesPage(getDriver());
    }

    public ManufacturerShoesPage goToManufacturersShoes(String manufacturer){
        String ____ = "//a[contains(text(), '?')]";
        final String xpathreg = ____.replace("?", manufacturer);

        manufacturers.hover();

        return new ManufacturerShoesPage(getDriver());
    }

}
