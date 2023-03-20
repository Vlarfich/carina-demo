package com.qaprosoft.carina.demo;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.LibertyWelcomePageBase;
import com.qaprosoft.carina.demo.mobile.gui.pages.android.Liberty.base.SecondWelcomePageBase;
import com.zebrunner.carina.utils.R;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.lang.invoke.MethodHandles;

public class AndroidRFEAppTest implements IAbstractTest, IAndroidUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @Test
    public void testOpening() {
        LibertyWelcomePageBase welcomePage = initPage(getDriver(), LibertyWelcomePageBase.class);

        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page isn't opened");

        SecondWelcomePageBase secondWelcomePageBase = welcomePage.launch();

        Assert.assertTrue(secondWelcomePageBase.isPageOpened(), "Second Welcome page isn't opened");
    }
}
