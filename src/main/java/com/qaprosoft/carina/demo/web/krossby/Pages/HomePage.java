package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.zebrunner.carina.utils.Configuration;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//h3//button[contains(@class, 'close')]")
    private ExtendedWebElement closePopUpButton;



    //@FindBy(xpath = "//a[contains(@href, 'https://kross.by/shoes/')]")
    @FindBy(xpath = "//span[contains(@data-hover, 'Каталог')]")
    private ExtendedWebElement catalog;

    @FindBy(id = "top-links")
    private Header header;

    public HomePage(WebDriver driver) {
        super(driver);
        setUiLoadedMarker(catalog);
        setPageAbsoluteURL(R.TESTDATA.get(Configuration.Parameter.URL.getKey()));
    }

    public void closePopUp(){
        closePopUpButton.click();
    }

    public CatalogPage clickCatalog(){
        catalog.click();
        return new CatalogPage(getDriver());
    }

    public SearchPage goToSearchPage(String str){
        return header.goToSearchPage(str);
    }

    public LoginPage loginPage(){
        return header.login();
    }
}
