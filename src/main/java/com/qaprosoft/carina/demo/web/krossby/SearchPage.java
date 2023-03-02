package com.qaprosoft.carina.demo.web.krossby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(id = "input-search")
    private ExtendedWebElement inpurSearch;

    //@FindBy(xpath = "//div[@class = 'caption']")
    @FindBy(xpath = "//div[@class = 'product-details']")
    private List<Shoe> shoes;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setRootExtendedElement(inpurSearch);
    }


    public List<Shoe> getShoes(){
        return shoes;
    }
}
