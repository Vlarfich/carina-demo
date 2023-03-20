package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.*;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.base.WelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages.CalendarPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages.FeedPage;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.outlook.pages.MailPage;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;
import java.time.LocalDate;
import java.time.Month;

public class MyMobileAndroidTest implements IAbstractTest, IAndroidUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    private final String FEED_TITLE = "Search";

    private MailPageBase enter() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);

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

        return mailPageBase;
    }

    @Test
    public void testEnter(){
        enter();
    }



    @Test
    public void testIfEmailIsRight() {
        MailPageBase mailPageBase = enter();

        SideBarPageBase sideBarPageBase = mailPageBase.openSideBar();

        Assert.assertTrue(sideBarPageBase.isPageOpened(), "Side Bar did not open");

        String sideBarEmail = sideBarPageBase.getEmailName();

        LOGGER.info("SideBar email name: " + sideBarEmail);

        String email = R.TESTDATA.get("username");

        Assert.assertEquals(sideBarEmail, email, "Account email and actual email names are not equal!");
    }


    @Test
    public void testSideBar() {
        MailPageBase mailPageBase = enter();

        SideBarPageBase sideBarPageBase = mailPageBase.openSideBar();

        Assert.assertTrue(sideBarPageBase.isPageOpened(), "Side Bar did not open");
    }

    @Test
    public void testCalendarIsOpening() {
        MailPageBase mailPageBase = enter();

        CalendarPage calendarPage = (CalendarPage) mailPageBase.openCalendar();

        Assert.assertTrue(calendarPage.isPageOpened(), "Calendar page isn't opened");

        LocalDate localDate = LocalDate.now();

        Month month = localDate.getMonth();

        LOGGER.info("Current month: " + month);

        String outlookMonth = calendarPage.getMonth();

        LOGGER.info("Outlook month: " + outlookMonth);

        Assert.assertTrue(outlookMonth.equalsIgnoreCase(month.toString()), "Wrong month in calendar!");
    }

    @Test
    public void testFeedIsOpening() {
        MailPageBase mailPageBase = enter();

        FeedPage feedPage = (FeedPage) mailPageBase.openFeed();

        Assert.assertTrue(feedPage.isPageOpened(), "Feed page isn't opened");

        String feedTitle = feedPage.getTitleText();

        Assert.assertEquals(feedTitle, FEED_TITLE, "Wrong title in feed page");
    }

}
