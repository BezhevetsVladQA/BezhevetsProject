package org.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParrentPage {
    Logger logger = Logger.getLogger(getClass());


    @FindBy(xpath = "//button[@id='burgerBtn']")
    private WebElement burgerMenu;

    @FindBy(xpath = "//a[@class='link' and contains(@href, '/products?categories=Body care')]/h3")
    private WebElement bodyCateOption;

    @FindBy(xpath = "//button[@class='css-ojnlvt']")
    private WebElement searchIcon;

    @FindBy(xpath = "//input[@placeholder='Write here']")
    private WebElement searchInputField;

    @FindBy(xpath = "//button[text()='SEARCH']")
    private WebElement searchButtonOfInputField;

    @FindBy(xpath = "//*[@href='/products' and @class='button']")
    private WebElement viewProductsButton;

    @FindBy(xpath = "//*[@class='css-1pr1sot']")
    private WebElement profileIcon;

    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "/";
    }

    public HomePage openPage() {
        webDriver.get(baseUrl);
        logger.info("Home page was opened with the URL: " + baseUrl);
        return this;
    }

    public HomePage clickOnSearchButton() {
        clickOnElement(searchIcon, "Search icon");
        return this;
    }

    public HomePage checkIsSearchInputFieldVisible() {
        checkIsElementVisible(searchInputField, "Search input field");
        return this;
    }

    public HomePage enterTextToSearchInputField(String productName) {
        clearAndEnterTextToElement(searchInputField, productName);
        return this;
    }

    public ProductsPage clickOnSearchButtonOfInputField() {
        clickOnElement(searchButtonOfInputField, "Search button");
        return new ProductsPage(webDriver);
    }

    public HomePage openBurgerMenu() {
        clickOnElement(burgerMenu, "Burger menu");
        return this;
    }

    public ProductsPage openBodyCareCategory() {
        clickOnElement(bodyCateOption);
        return new ProductsPage(webDriver);
    }

    public ProductsPage clickOnViewProductsButton() {
        clickOnElementWithWaitAfter(viewProductsButton, "View products button");
        return new ProductsPage(webDriver);
    }

    public RegistrationPage openRegistrationPage() {
        clickOnElementWithWaitAfter(profileIcon, "Profile icon");
        return new RegistrationPage(webDriver);
    }
}
