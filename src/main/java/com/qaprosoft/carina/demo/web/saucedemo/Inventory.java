package com.qaprosoft.carina.demo.web.saucedemo;


import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class Inventory extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "react-burger-menu-btn")
    private ExtendedWebElement menuOpenButton;

    @FindBy(xpath = "//div[@class = 'inventory_item']")
    private List<Product> products;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    private ExtendedWebElement cartPageBtn;

    @FindBy(xpath = "//a[@class='shopping_cart_link']//span")
    private ExtendedWebElement cartBadge;

    @FindBy(xpath = "//select[@class = 'product_sort_container']")
    private ExtendedWebElement selectFilter;


    public Inventory(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/inventory.html");
    }

    public Menu openMenu() {
        LOGGER.info("Open menu");
        menuOpenButton.click();
        return new Menu(getDriver());
    }

    public Product selectModel(String modelName) {
        LOGGER.info("Get model " + modelName);
        for (Product productModel : products) {
            if (productModel.getName().equalsIgnoreCase(modelName)) {
                return productModel;
            }
        }
        throw new RuntimeException("Unable to get model: " + modelName);
    }

    public void fillInCart() {
        LOGGER.info("Add all product to cart");
        for (Product productModel : products) {
            productModel.addToCart();
        }
    }

    public String getNumberOfItems() {
        LOGGER.info("Get number of items in cart");
        return cartBadge.getText();
    }

    public boolean isNumberOfItemsPresent() {
        return cartBadge.isElementPresent(1);
    }

    public CartPage openCartPage() {
        LOGGER.info("Open cart page");
        cartPageBtn.click();
        return new CartPage(driver);
    }

    public void changeFilterToLoHi() {
        selectFilter.select(2);
    }

    public void changeFilterToHiLo() {
        selectFilter.select(3);
    }

    public void changeFilterToAZ() {
        selectFilter.select(0);
    }
    public void changeFilterToZA() {
        selectFilter.select(1);
    }

    public boolean checkIfSortAZCorrect() {
       Product p = products.get(0);
       return (p.getName().equals("Sauce Labs Backpack"));
    }

    public boolean checkIfSortZACorrect() {
        Product p = products.get(0);
        return (p.getName().equals("Test.allTheThings() T-Shirt (Red)"));
    }

    public boolean checkIfSortLoToHiCorrect() {
        Product p = products.get(0);
        return (p.getName().equals("Sauce Labs Onesie"));
    }

    public boolean checkIfSortHiToLoCorrect() {
        Product p = products.get(0);
        return (p.getName().equals("Sauce Labs Fleece Jacket"));
    }
}