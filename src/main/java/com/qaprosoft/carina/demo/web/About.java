package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;

public class About extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    public About(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://saucelabs.com/");
    }
}