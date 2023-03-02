package com.qaprosoft.carina.demo.web.krossby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SearchBar extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@class, 'search')]")
    private ExtendedWebElement searchCover;

    @FindBy(xpath = "//input[contains(@class, 'form-control input-lg')]")
    private ExtendedWebElement input;

    @FindBy(xpath = "//span[contains(@class, 'button-search')]")
    private ExtendedWebElement searchButton;

    public SearchBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public SearchPage goToSearchPage(String str){
        inputSearch(str);
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public void inputSearch(String str){
        searchCover.hover();
        input.type(str);
    }

}
