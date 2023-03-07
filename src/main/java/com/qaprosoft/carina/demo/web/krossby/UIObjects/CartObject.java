package com.qaprosoft.carina.demo.web.krossby.UIObjects;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class CartObject extends AbstractUIObject {

    @FindBy(id = "cart-total")
    private ExtendedWebElement cartDiv;

    @FindBy(xpath = "./div[contains(@class, 'total-payment')]")
    private ExtendedWebElement total;

    public CartObject(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getText() {
        return cartDiv.getText();
    }

    public int getAmount() {
        String str = StringUtils.remove(getText(), "товар(ов)");
        str = StringUtils.remove(str, " ");
        str = StringUtils.substringBefore(str, "\n");
        return Integer.parseInt(str);
    }

    public  String getTotalText() {
        return total.getText();
    }

    public int getTotal() {
        String str = StringUtils.remove(getTotalText(), "BYN");
        str = StringUtils.remove(str, " ");
        str = StringUtils.substringBefore(str, "\n");
        return Integer.parseInt(str);
    }

}
