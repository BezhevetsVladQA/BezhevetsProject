package org.pages;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;


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

    @FindBy(xpath = "//*[@class='css-g0fl43' and text()='38']")
    private WebElement priceOfSearchedOilProduct;

    @FindBy(xpath = "//*[@class='css-19d4yc6' and text()='Massaging Oil']")
    private WebElement titleOfSearchedOilProduct;

    @FindBy(xpath = "//h1[text()='Results']")
    private WebElement resultsHeader;

    @FindBy(xpath = "//*[@class=\"css-vvu7zn\"]//..//p[text()='Peels']")
    private WebElement peelsCheckbox;

    @FindBy(xpath = "//button[@class='button css-zu1gxv']")
    private WebElement searchByFilterButton;

    @FindBy(xpath = "//*[@class='css-1vn32xo' and text()='Peels']")
    private WebElement peelsProducts;

    public ProductsPage(WebDriver webDriver) {
        super(webDriver);
    }

    Logger logger = Logger.getLogger(getClass());

    @Override
    protected String getRelativeUrl() {
        return "products";
    }

    public ProductsPage checkIsRedirectToProductsPage() {
        checkUrl();
        return this;
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
        clickOnElementWithWaitAfter(bagIcon, "Bag icon");
        return new BagPage(webDriver);
    }

    public ProductsPage checkIsResultsPageIsOpened() {
        checkIsElementVisible(resultsHeader, "Results header");
        return this;
    }

    public ProductsPage checkIsOilProductOilIsFound() {
        checkIsElementVisible(titleOfSearchedOilProduct, "Title of searched oil product");
        checkIsElementVisible(priceOfSearchedOilProduct, "Price of searched oil product");
        return this;
    }

    public ProductsPage setPeelsCheckbox() {
        setCheckboxAsChecked(peelsCheckbox);
        return this;
    }

    public ProductsPage clickOnSearchByFilterButton() {
        clickOnElementWithWaitAfter(searchByFilterButton, "Search button");
        return this;
    }

    public ProductsPage checkIsOnlyPeelsProductsVisible() {

            WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.visibilityOf(peelsProducts));

            List<WebElement> allPeelsElements = webDriver.findElements(By.xpath("//*[@class='" + peelsProducts.getAttribute("class") + "']"));

            // Only with 'Peels'
            for (WebElement element : allPeelsElements) {
                String text = element.getText().trim();
                // Start from 'Peels'
                if (!text.matches("^Peels.*")) {
                    Assert.fail("Found an item with text other than 'Peels': " + text);
                }
            }

            logger.info("Only 'Peels' are displayed on the page!");
            return this;
    }


}
