package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends ParrentPage {

    @FindBy(xpath = "//*[@href='/product/5489f4e2-a177-4957-84ff-3fddebecd480']//..//button")
    private WebElement addToBagTheOilProduct;

    @FindBy(xpath = "//*/div[contains(text(),'Product added to cart')]")
    private WebElement productAddToBagNotif;

    @FindBy(xpath = "//*[@href='/basket']/span[text()='1']")
    private WebElement oneItemInBag;

    @FindBy(xpath = "//*[@class='css-yx58nr']")
    private WebElement bagIcon;

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "products";
    }

    public ProductsPage addOilProductToBag() {
        clickOnElement(addToBagTheOilProduct);
        return this;
    }

    public ProductsPage checkIsProductAddToBagNotifVisible() {
        checkIsElementVisible(productAddToBagNotif);
        return this;
    }

    public ProductsPage checkIsOneItemInBagVisible() {
        checkIsElementVisible(oneItemInBag);
        return this;
    }

    public ProductsPage clickOnAddedProdctNotif() {
        clickOnElement(productAddToBagNotif);
        return this;
    }

    public BagPage openBag() {
        clickOnElement(bagIcon, "Bag icon");
        return new BagPage(webDriver);
    }
}
