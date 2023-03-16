package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.krossby.Models.Shoe;
import com.qaprosoft.carina.demo.web.krossby.Models.User;
import com.qaprosoft.carina.demo.web.krossby.Models.UserBuilder;
import com.qaprosoft.carina.demo.web.krossby.Pages.*;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.QuickView;
import com.zebrunner.carina.utils.R;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.invoke.MethodHandles;
import java.util.Comparator;
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

        String userName = (R.TESTDATA.get("username"));
        String pass = (R.TESTDATA.get("password"));
        LOGGER.info("Trying to login user: " + userName + " ,  with password: " + pass);

        User user = new UserBuilder().username(userName).password(pass).build();

        AccountPage accountPage = loginPage.login(user);

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

        String userName = (R.TESTDATA.get("randomuser"));
        String pass = (R.TESTDATA.get("randompass"));
        LOGGER.info("Trying to login user: " + userName + " ,  with password: " + pass);

        User user = new UserBuilder().username(userName).password(pass).build();

        AccountPage accountPage = loginPage.login(user);

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
    public void testQuickViewOpens() {
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
        QuickView quickView = shoe.getQuickView();

        Assert.assertTrue(quickView.isUIObjectPresent(), "QuickView is not opened");
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
    public void testCartWithSize() {
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

        Assert.assertTrue(checkOutPage.isPageOpened(), "QuickView is not opened!");
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

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        for (Shoe shoe : shoes) {
            int shoePrice = shoe.getPrice();
            LOGGER.info("" + shoePrice);
            Assert.assertTrue(shoePrice <= maxPrice, "Shoe price is not correct after filter!");
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

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        for(Shoe shoe : shoes) {
            LOGGER.info(shoe.getShoePrice());
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
        catalogPage.pause(1);

        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        for (Shoe shoe : shoes) {
            int shoePrice = shoe.getPrice();
            LOGGER.info("" + shoePrice);
            Assert.assertTrue(shoePrice >= minPrice && shoePrice <= maxPrice, "Shoe price is not correct after filter!");
        }
    }


    @Test
    public void testSortingAZ() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        Comparator<Shoe> comparatorAZ = new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                return (o1.getShoeModel().compareTo(o2.getShoeModel()));
            }
        };

        catalogPage.sortAZ();

        //Assert.assertTrue(catalogPage.checkIfSortedByComparator(comparatorAZ), "A to Z name sort failed");

        Comparator<Shoe> comparatorZA = new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                return o1.getShoeModel().compareTo(o2.getShoeModel());
            }
        };

        catalogPage.sortZA();

        //Assert.assertTrue(catalogPage.checkIfSortedByComparator(comparatorZA), "Z to A name sort failed");

    }


    @Test
    public void testSortLH() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        Comparator<Shoe> comparatorLH = new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                return Integer.compare(o1.getPrice(), o2.getPrice());
            }
        };

        catalogPage.sortLH();

        Assert.assertTrue(catalogPage.checkIfSortedByComparator(comparatorLH), "Low to High price sort failed");

    }

    @Test
    public void testSortHL() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        Comparator<Shoe> comparatorHL = new Comparator<Shoe>() {
            @Override
            public int compare(Shoe o1, Shoe o2) {
                return Integer.compare(o2.getPrice(), o1.getPrice());
            }
        };

        catalogPage.sortHL();

        Assert.assertTrue(catalogPage.checkIfSortedByComparator(comparatorHL), "High to Low price sort failed");


    }

    @Test
    public void testCartNumberOfItems(){
        HomePage homePage = new HomePage(getDriver());
        homePage.open();

        Assert.assertTrue(homePage.isPageOpened(), "Home page is not opened!");

        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();

        Assert.assertTrue(catalogPage.isPageOpened(), "Catalog page is not opened!");

        catalogPage.closePopUp();
        List<Shoe> shoes = catalogPage.getShoes();

        Assert.assertFalse(shoes.isEmpty(), "No shoes found in catalog!");

        int total = 0;

        int cartElements = R.TESTDATA.getInt("cart_amount");

        int shoePrice = shoes.get(2).getPrice();

        SoftAssert softAssert = new SoftAssert();

        for(int i = 0; i < cartElements; i++) {
            Shoe shoe = shoes.get(2);
            total += shoe.getPrice();
            CheckOutPage checkOutPage = shoe.buyWithSize();
            checkOutPage.pause(1);
            //Assert.assertEquals(checkOutPage.getAmount(), i + 1, "Wrong amount of items in cart");
            //Assert.assertEquals(checkOutPage.getTotal(), total + 1, "Wrong amount of items in cart");
            //softAssert.assertEquals(checkOutPage.getTotal(), total + 1, "Wrong amount of items in cart");
            CatalogPage catalogPage2 = checkOutPage.clickCatalog();
            shoes = catalogPage2.getShoes();
        }

        Assert.assertTrue(total / cartElements == shoePrice, "wrog total price");
        //Assert.assertTrue(checkOutPage.isPageOpened(), "QuickView is not opened!");
        String string = "";
    }


    // 24442
    // java maven appium xcode
}
