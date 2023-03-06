package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class SelectSort extends AbstractUIObject {

    @FindBy(id = "input-sort")
    private ExtendedWebElement selects;

    public SelectSort(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
        setUiLoadedMarker(selects);
    }

    public void sortAZ() {
        selects.select(1);
    }

    public void sortZA() {
        selects.select(2);
    }

    public void sortLH() {
        selects.select(3);
    }

    public void sortHL() {
        selects.select(4);
    }

}
