package com.qaprosoft.carina.demo.web;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.invoke.MethodHandles;
import java.util.Random;

public class HomePage extends AbstractPage {
    private static final Logger LOGGER = LoggerFactory.getLogger(MethodHandles.lookup().lookupClass());

    @FindBy(id = "user-name")
    private ExtendedWebElement usernameInput;

    @FindBy(id = "password")
    private ExtendedWebElement passwordInput;

    @FindBy(id = "login-button")
    private ExtendedWebElement loginButton;


    @FindBy(xpath = "//div[@class='login_password']")
    private ExtendedWebElement password;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://www.saucedemo.com/");
    }

    public Inventory login() {
        //LOGGER.info("username");
        usernameInput.type("standard_user");
        //LOGGER.info("password");
        passwordInput.type("secret_sauce");
        loginButton.click();
        return new Inventory(getDriver());
    }

    public void loginFail() {
        //LOGGER.info("username");
        usernameInput.type("");
        //LOGGER.info("password");
        passwordInput.type("");
        loginButton.click();
    }

    public boolean isErrorDisplay() {
        ExtendedWebElement errorWindow = findExtendedWebElement(By.xpath("//h3[@data-test='error']"));
        if (errorWindow == null) {
            return false;
        }
        return errorWindow.isElementPresent();
    }

    public void closeErrorDisplay() {
        ExtendedWebElement closeErrorWindowBtn = findExtendedWebElement(By.xpath("//button[@class='error-button']"));
        closeErrorWindowBtn.click();
    }
}