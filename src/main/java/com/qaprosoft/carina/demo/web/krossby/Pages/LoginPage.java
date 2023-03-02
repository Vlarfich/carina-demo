package com.qaprosoft.carina.demo.web.krossby.Pages;

import com.beust.ah.A;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Header;
import com.qaprosoft.carina.demo.web.krossby.UIObjects.Navigation;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(id = "top-links")
    private Header header;

    @FindBy(id = "menu")
    private Navigation navigation;

    @FindBy(id = "input-email")
    private ExtendedWebElement loginInput;

    @FindBy(id = "input-password")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//input[contains(@type, 'submit')]")
    private ExtendedWebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL("https://kross.by/login/");
    }

    public void inputLogin(String login){
        loginInput.type(login);
    }

    public void inputPassword(String password){
        passwordInput.type(password);
    }

    public AccountPage pressLogin(){
        loginButton.click();
        return new AccountPage(getDriver());
    }

    public AccountPage login(String user, String pass){
        inputLogin(user);
        inputPassword(pass);
        return pressLogin();
    }
}
