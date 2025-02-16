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

    public HomePage openBurgerMenu() {
        clickOnElement(burgerMenu, "Burger menu");
        return this;
    }

    public ProductsPage openBodyCareCategory() {
        clickOnElement(bodyCateOption);
        return new ProductsPage(webDriver);
    }
}
