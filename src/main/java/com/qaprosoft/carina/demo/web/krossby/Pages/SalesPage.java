package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.Shoe;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SalesPage extends AbstractPage {

    @FindBy(id = "top-links")
    private Header header;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//h3//button[contains(@class, 'close')]")
    private ExtendedWebElement closePopUpButton;

    @FindBy(xpath = "//div[@class = 'caption']")
    private List<Shoe> shoes;

    public SalesPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://kross.by/specials/");
    }

    public void closePopUp() {
        closePopUpButton.click();
    }

    public List<Shoe> getShoes() {
        return shoes;
    }

}
