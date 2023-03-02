package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.saucedemo.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyWebTest implements IAbstractTest {

    @Test
    public void testLoginAndAboutPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Failed to open site");

        Inventory inventoryPage = homePage.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Login fail");

        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu fail");

        About aboutPage = menu.openAboutPage();
        Assert.assertTrue(aboutPage.isPageOpened(), "About fail");

        getDriver().navigate().back();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Back button fail");

        // logout check
        menu.logout();
        Assert.assertTrue(homePage.isPageOpened(), "Logout failed");
    }

    @Test
    public void testBlockedUser() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.loginFail();
        Assert.assertTrue(homePage.isErrorDisplay(), "Error message fail");

        homePage.closeErrorDisplay();
        Assert.assertFalse(homePage.isErrorDisplay(), "Error message close fail");
    }

    @Test
    public void testInfoAboutProduct() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Login fail");

        Inventory inventoryPage = homePage.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory fail");

        Product product = inventoryPage.selectModel("Sauce Labs Fleece Jacket");

        ProductInfo productInfo = product.openProductPage();
        Assert.assertTrue(productInfo.isPageOpened(), "Product info fail");

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(productInfo.readName(), product.getName());
        softAssert.assertEquals(productInfo.readPrice(), product.getPrice());
        softAssert.assertEquals(productInfo.readInfo(), product.getDescription());
        softAssert.assertAll();
    }

    @Test
    public void testCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Login fail");

        Inventory inventoryPage = homePage.login();

        inventoryPage.fillInCart();

        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu is not opened");
        menu.resetCart();
        Assert.assertFalse(inventoryPage.isNumberOfItemsPresent(), "The cart is not reset");
    }

    @Test
    public void testOrder() {
        String productName = "Sauce Labs Fleece Jacket";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Inventory inventoryPage = homePage.login();

        Product productModel = inventoryPage.selectModel(productName);
        productModel.addToCart();

        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
        CartPage cartPage = inventoryPage.openCartPage();

        Assert.assertEquals(cartPage.getItemsInCart(), 1, "Items in cart are not match with order");
        CheckoutPage checkoutPage = cartPage.openCheckoutPage();
        checkoutPage.fillInCheckoutForm();
    }

    @Test
    public void testCartWithLogout() {
        String productName = "Sauce Labs Fleece Jacket";
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        Inventory inventoryPage = homePage.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        Product productModel = inventoryPage.selectModel(productName);
        productModel.addToCart();
        Assert.assertTrue(productModel.isRemoveButtonDisplay(), "The item is not add to cart");
        Assert.assertTrue(inventoryPage.isNumberOfItemsPresent(), "The cart is not fill in");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
        Menu menu = inventoryPage.openMenu();
        Assert.assertTrue(menu.isUIObjectPresent(), "Menu is not opened");
        menu.logout();
        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");
        inventoryPage = homePage.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page is not opened!");
        Assert.assertEquals(inventoryPage.getNumberOfItems(), "1", "Number of items is not valid");
    }

    @Test
    public void testProductFilter() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        Assert.assertTrue(homePage.isPageOpened(), "Login fail");
        Inventory inventoryPage = homePage.login();
        Assert.assertTrue(inventoryPage.isPageOpened(), "Inventory page fail");
        inventoryPage.changeFilterToLoHi();
        Assert.assertTrue(inventoryPage.checkIfSortLoToHiCorrect(), "Filter fail");
        inventoryPage.changeFilterToHiLo();
        Assert.assertTrue(inventoryPage.checkIfSortHiToLoCorrect(), "Filter fail");
        inventoryPage.changeFilterToAZ();
        Assert.assertTrue(inventoryPage.checkIfSortAZCorrect(), "Filter fail");
        inventoryPage.changeFilterToZA();
        Assert.assertTrue(inventoryPage.checkIfSortZACorrect(), "Filter fail");
    }

}