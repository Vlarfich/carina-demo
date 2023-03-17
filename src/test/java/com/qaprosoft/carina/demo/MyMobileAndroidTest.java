package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.*;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyMobileAndroidTest implements IAbstractTest, IAndroidUtils {

    @Test
    public void testEnter(){
        LibertyWelcomePageBase welcomePage = initPage(getDriver(), LibertyWelcomePageBase.class);

        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase secondWelcomePage = welcomePage.clickNextBtn();

        Assert.assertTrue(secondWelcomePage.isPageOpened(), "Login page isn't opened");

        AccountChoosingPageBase accountChoosingPageBase = secondWelcomePage.clickAddAccountButton();

        Assert.assertTrue(accountChoosingPageBase.isPageOpened(), "Account page isn't opened");

        PolicyPageBase policyPageBase = accountChoosingPageBase.choose(R.TESTDATA.get("username"));

        Assert.assertTrue(policyPageBase.isPageOpened(), "Policy page isn't opened");

        AddAnotherAccountPageBase addAnotherAccountPageBase = policyPageBase.allow();

        Assert.assertTrue(addAnotherAccountPageBase.isPageOpened(), "AddAnotherAccount page isn't opened");

        MailPageBase mailPageBase = addAnotherAccountPageBase.later();

        Assert.assertTrue(mailPageBase.isPageOpened(), "Mail page isn't opened");
    }



    @Test
    public void testIfEmailIsRight() {
        LibertyWelcomePageBase welcomePage = initPage(getDriver(), LibertyWelcomePageBase.class);

        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase secondWelcomePage = welcomePage.clickNextBtn();

        Assert.assertTrue(secondWelcomePage.isPageOpened(), "Login page isn't opened");

        AccountChoosingPageBase accountChoosingPageBase = secondWelcomePage.clickAddAccountButton();

        Assert.assertTrue(accountChoosingPageBase.isPageOpened(), "Account page isn't opened");

        PolicyPageBase policyPageBase = accountChoosingPageBase.choose(R.TESTDATA.get("username"));

        Assert.assertTrue(policyPageBase.isPageOpened(), "Policy page isn't opened");

        AddAnotherAccountPageBase addAnotherAccountPageBase = policyPageBase.allow();

        Assert.assertTrue(addAnotherAccountPageBase.isPageOpened(), "AddAnotherAccount page isn't opened");

        MailPageBase mailPageBase = addAnotherAccountPageBase.later();

        Assert.assertTrue(mailPageBase.isPageOpened(), "Mail page isn't opened");

        SideBarPageBase sideBarPageBase = mailPageBase.openSideBar();

        Assert.assertTrue(sideBarPageBase.isPageOpened(), "Side Bar did not open");
    }


    @Test
    public void testSideBar() {
        LibertyWelcomePageBase welcomePage = initPage(getDriver(), LibertyWelcomePageBase.class);

        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        LoginPageBase secondWelcomePage = welcomePage.clickNextBtn();

        Assert.assertTrue(secondWelcomePage.isPageOpened(), "Login page isn't opened");

        AccountChoosingPageBase accountChoosingPageBase = secondWelcomePage.clickAddAccountButton();

        Assert.assertTrue(accountChoosingPageBase.isPageOpened(), "Account page isn't opened");

        PolicyPageBase policyPageBase = accountChoosingPageBase.choose(R.TESTDATA.get("username"));

        Assert.assertTrue(policyPageBase.isPageOpened(), "Policy page isn't opened");

        AddAnotherAccountPageBase addAnotherAccountPageBase = policyPageBase.allow();

        Assert.assertTrue(addAnotherAccountPageBase.isPageOpened(), "AddAnotherAccount page isn't opened");

        MailPageBase mailPageBase = addAnotherAccountPageBase.later();

        Assert.assertTrue(mailPageBase.isPageOpened(), "Mail page isn't opened");

        SideBarPageBase sideBarPageBase = mailPageBase.openSideBar();

        Assert.assertTrue(sideBarPageBase.isPageOpened(), "Side Bar did not open");
    }

}
