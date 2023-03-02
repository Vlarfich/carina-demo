package com.qaprosoft.carina.demo.web.krossby;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CatalogPage extends AbstractPage {

    @FindBy(xpath = "//div[contains(@class, 'modal-body')]//h3//button[contains(@class, 'close')]")
    private ExtendedWebElement closePopUpButton;

    @FindBy(xpath = "//div[@class = 'caption']")
    private List<Shoe> shoes;

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
}
