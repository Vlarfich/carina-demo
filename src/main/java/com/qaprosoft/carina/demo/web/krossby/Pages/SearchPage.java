package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.PageOpeningStrategy;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.Shoe;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends AbstractPage {

    @FindBy(id = "top-links")
    private Header header;
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

    public SearchPage goToSearchPage(String str){
        return header.goToSearchPage(str);
    }

    public LoginPage loginPage(){
        return header.login();
    }
}
