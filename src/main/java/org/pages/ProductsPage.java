package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductsPage extends ParrentPage {

    @FindBy(xpath = "//*[@href='/product/5489f4e2-a177-4957-84ff-3fddebecd480']//..//button")
    private WebElement addToBagTheOilProduct;

    @FindBy(xpath = "//*[@href=\"/product/57d5d4e9-4c0b-4398-8c9f-5072f75699fb\"]//..//button")
    private WebElement addToBagTheGommageProduct;

    @FindBy(xpath = "//*/div[contains(text(),'Product added to cart')]")
    private WebElement productAddToBagNotif;

    @FindBy(xpath = "//*[@href='/basket']/span[text()='1']")
    private WebElement oneItemInBag;

    @FindBy(xpath = "//*[@class='css-yx58nr']")
    private WebElement bagIcon;

    @FindBy(xpath = "//h1[text()='Body care']")
    private WebElement bodyCareHeader;

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

    public ProductsPage addGommageProductToBag() {
        clickOnElement(addToBagTheGommageProduct);
        return this;
    }

    public ProductsPage checkIsProductAddToBagNotifVisible() {
        checkIsElementVisible(productAddToBagNotif, "Product added to bag notification");
        return this;
    }

    public ProductsPage checkIsOneItemInBagVisible() {
        checkIsElementVisible(oneItemInBag, "One item in bag");
        return this;
    }

    public ProductsPage clickOnAddedProdctNotif() {
        clickOnElement(productAddToBagNotif, "Notification");
        return this;
    }

    public ProductsPage checkIsBodyCareHeaderVisible() {
        checkIsElementVisible(bodyCareHeader, "Body care header");
        return this;
    }

    public BagPage openBag() {
        clickOnElement(bagIcon, "Bag icon");
        return new BagPage(webDriver);
    }
}
