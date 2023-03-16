package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.*;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyMobileAndroidTest implements IAbstractTest, IAndroidUtils {

    @Test
    public void testEnter(){
        LibertyWelcomePageBase welcomePage = initPage(getDriver(), LibertyWelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");
        LoginPage secondWelcomePage = welcomePage.clickNextBtn();
        Assert.assertTrue(secondWelcomePage.isPageOpened(), "Login page isn't opened");

    }


}
