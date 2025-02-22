package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParrentPage {

    @FindBy(xpath = "//input[@placeholder='Enter phone number']")
    private WebElement inputPhoneNumber;

    @FindBy(xpath = "//*[@class='button ']/span[text()='Get an SMS']")
    private WebElement GetAnSMSButton;

    @FindBy(xpath = "//*[text()='Phone number not found']")
    private WebElement errorMessage;

    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "login";
    }

    public LoginPage checkIsRedirectToLoginPage() {
        checkUrl();
        return this;
    }

    public LoginPage enterNotRegisteredNumber() {
        clearAndEnterTextToElement(inputPhoneNumber, "000000000");
        return this;
    }

    public LoginPage clickOnGetAnSMSButton() {
        clickOnElement(GetAnSMSButton, "Get an SMS button");
        return this;
    }

    public LoginPage checkIsErrorMessageVisible() {
        checkIsElementVisible(errorMessage, "Error message");
        return this;
    }
}
