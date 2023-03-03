package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.krossby.*;
import com.qaprosoft.carina.demo.web.krossby.Pages.*;
import com.zebrunner.carina.utils.R;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MySecondWebTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());


    @Test
    public void testValidLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.closePopUp();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        LoginPage loginPage = homePage.loginPage();

        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");

        String user = (R.TESTDATA.get("username"));
        String pass = (R.TESTDATA.get("password"));
        LOGGER.info("Trying to login user: " + user + " ,  with password: " + pass);
        AccountPage accountPage = loginPage.login(user, pass);

        Assert.assertTrue(accountPage.isPageOpened(), "Account page is not opened!");
    }

    @Test
    public void testRandomLogin() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.closePopUp();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        LoginPage loginPage = homePage.loginPage();

        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");

        String user = (R.TESTDATA.get("randomuser"));
        String pass = (R.TESTDATA.get("randompass"));
        LOGGER.info("Trying to login user: " + user + " ,  with password: " + pass);
        AccountPage accountPage = loginPage.login(user, pass);

        Assert.assertFalse(accountPage.isPageOpened(2), "Random user + password passed authorization!");
    }


    @Test
    public void testSalesPage() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        SalesPage salesPage = homePage.goToSalesPage();

        Assert.assertTrue(salesPage.isPageOpened(), "Sales page is not opened!");

        salesPage.closePopUp();
        List<Shoe> shoes = salesPage.getShoes();
        boolean isSmthngOnSale = false;
        for (Shoe shoe : shoes) {
            if (shoe.getShoePrice().contains("\n")) {
                isSmthngOnSale = true;
                break;
            }
        }
        Assert.assertTrue(isSmthngOnSale, "Nothing is on sale on sales page!");
    }


    @Test
    public void testSearch() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        String shoeForSearch = R.TESTDATA.get("shoeforsearch");
        SearchPage searchPage = homePage.goToSearchPage(shoeForSearch);

        Assert.assertTrue(searchPage.isPageOpened(), "Search page is not opened!");

        List<Shoe> searchedShoes = searchPage.getShoes();

        Assert.assertFalse(CollectionUtils.isEmpty(searchedShoes), "No shoes found!");

        SoftAssert softAssert = new SoftAssert();

        for (Shoe shoe : searchedShoes) {
            LOGGER.info(shoe.getShoeModel());
            softAssert.assertTrue(StringUtils.containsIgnoreCase(shoe.getShoeModel(), shoeForSearch),
                    "Invalid search results for " + shoe.getShoeModel());
        }

        softAssert.assertAll();
    }


    @Test
    public void testCartWithoutChoosingSize() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        Shoe shoe = shoes.get(0);
        CheckOutPage checkOutPage = shoe.buyNoSize();

        Assert.assertFalse(checkOutPage.isPageOpened(5), "Checkout page opened even though we didn't choose the size!");
    }

    @Test
    public void testValidCart() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        Shoe shoe = shoes.get(0);
        CheckOutPage checkOutPage = shoe.buyWithSize();

        Assert.assertTrue(checkOutPage.isPageOpened(), "Checkout page is not opened!");
    }

    @Test
    public void testFilterMaxPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        int maxPrice = R.TESTDATA.getInt("maxprice");
        catalogPage.inputMaxPrice(maxPrice);

        List<Shoe> shoes = catalogPage.getShoes();
        for (Shoe shoe : shoes) {
            Assert.assertTrue(shoe.getPrice() <= maxPrice, "Shoe price is not correct after filter!");
        }
    }


    @Test
    public void testFilterMinPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        int minPrice = R.TESTDATA.getInt("minprice");
        catalogPage.inputMinPrice(minPrice);

        List<Shoe> shoes = catalogPage.getShoes();
        for (Shoe shoe : shoes) {
            Assert.assertTrue(shoe.getPrice() >= minPrice, "Shoe price is not correct after filter!");
        }
    }

    @Test
    public void testFilterMinMaxPrice() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        int minPrice = R.TESTDATA.getInt("minprice");
        int maxPrice = R.TESTDATA.getInt("maxprice");
        catalogPage.inputMinPrice(minPrice);
        catalogPage.inputMaxPrice(maxPrice);

        List<Shoe> shoes = catalogPage.getShoes();
        for (Shoe shoe : shoes) {
            int shoePrice = shoe.getPrice();
            Assert.assertTrue(shoePrice >= minPrice && shoePrice <= maxPrice, "Shoe price is not correct after filter!");
        }
    }



}
