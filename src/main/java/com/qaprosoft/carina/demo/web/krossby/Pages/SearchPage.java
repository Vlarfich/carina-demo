package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.Shoe;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(id = "top-links")
    private Header header;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(id = "input-search")
    private ExtendedWebElement inputSearch;

    @FindBy(id = "button-search")
    private ExtendedWebElement searchButton;

    //@FindBy(xpath = "//div[@class = 'caption']")
    @FindBy(xpath = "//div[@class = 'product-details']")
    private List<Shoe> shoes;

    public SearchPage(WebDriver driver) {
        super(driver);
        setPageOpeningStrategy(PageOpeningStrategy.BY_ELEMENT);
        setRootExtendedElement(inputSearch);
        setUiLoadedMarker(inputSearch);
    }


    public List<Shoe> getShoes(){
        return shoes;
    }

    public SearchPage goToSearchPage(String str){
        return header.goToSearchPage(str);
    }

    public LoginPage loginPage(){
        return header.login();
    }

    public void inputSearch(String search) {
        inputSearch.type(search);
    }

    public SearchPage clickSearch(){
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public SearchPage search(String str) {
        inputSearch(str);
        return clickSearch();
    }
}
