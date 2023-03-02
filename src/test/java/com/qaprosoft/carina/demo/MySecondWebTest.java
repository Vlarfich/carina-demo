package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.demo.web.krossby.*;
import com.zebrunner.carina.utils.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.util.List;

public class MySecondWebTest implements IAbstractTest {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void test1(){
        LOGGER.info(R.TESTDATA.get("username"));
        LOGGER.info(R.TESTDATA.get("password"));

        HomePage homePage = new HomePage(getDriver());
        homePage.open();
        homePage.closePopUp();
        CatalogPage catalogPage = homePage.clickCatalog();
        catalogPage.closePopUp();
        List<Shoe> shoeList = catalogPage.getShoes();
        for(Shoe shoe : shoeList) {
            LOGGER.info(shoe.toString());
        }
        LOGGER.info("_______________________________________________");
        SearchBar searchBar = homePage.getSearchBar();
        SearchPage searchPage = searchBar.goToSearchPage(R.TESTDATA.get("shoeforsearch"));
        List<Shoe> searchedShoes = searchPage.getShoes();
        for (Shoe shoe : searchedShoes){
            LOGGER.info(shoe.toString());
        }

    }
}
