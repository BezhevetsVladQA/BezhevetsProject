package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends ParrentPage {

    @FindBy(xpath = "//*[text()='Massaging Oil']")
    private WebElement productOilInBag;

    public BagPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "basket";
    }

    public BagPage checkIsProductOilInBagVisible() {
        checkIsElementVisible(productOilInBag);
        return this;
    }
}
