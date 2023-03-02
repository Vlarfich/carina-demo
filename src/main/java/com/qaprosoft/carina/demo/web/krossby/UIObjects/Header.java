package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.web.krossby.Pages.LoginPage;
import com.qaprosoft.carina.demo.web.krossby.Pages.SalesPage;
import com.qaprosoft.carina.demo.web.krossby.Pages.SearchPage;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class Header extends AbstractUIObject {

    @FindBy(xpath = "//div[contains(@class, 'search')]")
    private ExtendedWebElement searchCover;

    @FindBy(xpath = "//input[contains(@class, 'form-control input-lg')]")
    private ExtendedWebElement input;

    @FindBy(xpath = "//span[contains(@class, 'button-search')]")
    private ExtendedWebElement searchButton;


    @FindBy(xpath = "//i[contains(@class, 'fa fa-bars')]")
    private ExtendedWebElement burgerToHover;

    @FindBy(xpath = "//a[text()='Вход']")
    private ExtendedWebElement login;




    public SearchPage goToSearchPage(String str) {
        inputSearch(str);
        searchButton.click();
        return new SearchPage(getDriver());
    }

    public void inputSearch(String str) {
        searchCover.hover();
        input.type(str);
    }



    public LoginPage login(){
        burgerToHover.click();
        login.click();
        return new LoginPage(getDriver());
    }





    public Header(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }
}
