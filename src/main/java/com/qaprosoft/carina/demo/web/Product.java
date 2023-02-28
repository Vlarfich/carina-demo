package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class Product extends AbstractUIObject {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());
    private final static String REMOVE_BUTTON_XPATH = ".//button[contains(@id, 'remove')]";

    @FindBy(xpath = ".//div[@class = 'inventory_item_name']")
    private ExtendedWebElement productName;

    @FindBy(xpath = ".//a[contains(@id, 'title_link')]")
    private ExtendedWebElement productPageOpen;

    @FindBy(xpath = ".//div[@class = 'inventory_item_desc']")
    private ExtendedWebElement productDescription;

    @FindBy(xpath = ".//div[@class='inventory_item_price']")
    private ExtendedWebElement productPrice;

    @FindBy(xpath = ".//button[contains(@id, 'add-to-cart')]")
    private ExtendedWebElement addCart;

    public Product(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public String getName() {
        return productName.getText();
    }

    public ProductInfo openProductPage() {
        productPageOpen.click();
        return new ProductInfo(driver);
    }

    public String getDescription() {
        return productDescription.getText();
    }

    public String getPrice() {
        return productPrice.getText();
    }

    public void addToCart() {
        //LOGGER.info("Add to cart");
        addCart.click();
    }

    public boolean isRemoveButtonDisplay() {
        ExtendedWebElement removeButton = findExtendedWebElement(By.xpath(REMOVE_BUTTON_XPATH));
        if (removeButton == null) {
            return false;
        }
        return removeButton.isElementPresent();
    }

    public void removeFromCart() {
        ExtendedWebElement removeButton = findExtendedWebElement(By.xpath(REMOVE_BUTTON_XPATH));
        removeButton.click();
    }
}
