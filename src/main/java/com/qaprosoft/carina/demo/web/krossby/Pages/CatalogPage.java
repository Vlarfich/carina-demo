package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.Shoe;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.FilterOptions;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.SelectSort;
import com.zebrunner.carina.utils.R;
import org.apache.logging.log4j.util.PropertySource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class CatalogPage extends AbstractPage {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "top-links")
    private Header header;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//h3//button[contains(@class, 'close')]")
    private ExtendedWebElement closePopUpButton;

    @FindBy(xpath = "//div[@class = 'caption']")
    private List<Shoe> shoes;

    @FindBy(xpath = "//div[contains(@class, 'mfilter-price-inputs')]")
    private FilterOptions filterOptions;

    @FindBy(xpath = "//div[contains(@class, 'col-md-3 text-right sort')]")
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

    public SearchPage goToSearchPage(String str) {
        return header.goToSearchPage(str);
    }

    public LoginPage loginPage() {
        return header.login();
    }

    public void inputMaxPrice(int max) {
        filterOptions.inputMaxPrice(max);
    }

    public void inputMinPrice(int min) {
        filterOptions.inputMinPrice(min);
    }

    public void sortAZ() {
        selectSort.sortAZ();
    }

    public void sortZA() {
        selectSort.sortZA();
    }

    public void sortLH() {
        selectSort.sortLH();
    }

    public void sortHL() {
        selectSort.sortHL();
    }

    public boolean checkIfSortedByComparator(Comparator<Shoe> comparator) {
        ArrayList<Shoe> shoes2 = new ArrayList<>(shoes);
        shoes2.sort(comparator);
        for (int i = 0; i < shoes.size(); i++) {
            if (!shoes.get(i).equals(shoes2.get(i))) {
                return false;
            }

        }
        return true;
    }

}
