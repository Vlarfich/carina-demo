package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.Shoe;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.FilterOptions;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.SelectSort;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(id = "top-links")
    private Header header;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//h3//button[contains(@class, 'close')]")
    private ExtendedWebElement closePopUpButton;

    @FindBy(xpath = "//div[contains(@class, 'row cat')]//.//div[@class = 'caption']")
    private List<Shoe> shoes;

    @FindBy(xpath = "//div[contains(@class, 'mfilter-price-inputs')]")
    private FilterOptions filterOptions;

    @FindBy(id = "input-sort")
    private SelectSort selectSort;

    public CatalogPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.TESTDATA.get("catalogurl"));
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

    public void closePopUp() {
        closePopUpButton.click();
    }

    public SearchPage goToSearchPage(String str){
        return header.goToSearchPage(str);
    }

    public LoginPage loginPage(){
        return header.login();
    }

    public void inputMaxPrice(int max) {
        filterOptions.inputMaxPrice(max);
    }

    public void inputMinPrice(int min) {
        filterOptions.inputMinPrice(min);
    }
}
