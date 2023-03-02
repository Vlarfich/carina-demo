package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.web.krossby.*;
import com.qaprosoft.carina.demo.web.krossby.Pages.*;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MySecondWebTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void test1() {
        LOGGER.info(R.TESTDATA.get("username"));
        LOGGER.info(R.TESTDATA.get("password"));

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();
        catalogPage.closePopUp();
        List<Shoe> shoeList = catalogPage.getShoes();
        for (Shoe shoe : shoeList) {
            LOGGER.info(shoe.toString());
        }
        LOGGER.info("_______________________________________________");
        SearchPage searchPage = catalogPage.goToSearchPage(R.TESTDATA.get("shoeforsearch"));
        List<Shoe> searchedShoes = searchPage.getShoes();
        for (Shoe shoe : searchedShoes) {
            LOGGER.info(shoe.toString());
        }

        LoginPage loginPage = searchPage.loginPage();
        String user = (R.TESTDATA.get("username"));
        String pass = (R.TESTDATA.get("password"));
        AccountPage accountPage = loginPage.login(user, pass);
    }

    @Test
    public void test2() {
        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.closePopUp();
        LoginPage loginPage = homePage.loginPage();
        loginPage.inputLogin(R.TESTDATA.get("username"));
        loginPage.inputPassword(R.TESTDATA.get("password"));
    }
}
