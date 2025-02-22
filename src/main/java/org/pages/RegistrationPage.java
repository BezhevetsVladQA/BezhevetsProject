package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends ParrentPage {

    @FindBy(xpath = "//*[@href=\"/login\"]")
    private WebElement loginButton;

    public RegistrationPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "register";
    }

    public RegistrationPage checkIsRedirectToRegistrationPage() {
        checkUrl();
        return this;
    }

    public LoginPage clickOnLoginButton() {
        clickOnElementWithWaitAfter(loginButton, "Login button");
        return new LoginPage(webDriver);
    }

}
