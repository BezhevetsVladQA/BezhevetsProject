package org.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BagPage extends ParrentPage {

    @FindBy(xpath = "//*[text()='Massaging Oil']")
    private WebElement productOilInBag;

    @FindBy(xpath = "//h2[text()='Gommage']")
    private WebElement productGommageInBag;

    @FindBy(xpath = "//*[@class='css-14qn862']/input[@type='text' and @value='1']")
    private WebElement currentQuantityOfProductIsOne;

    @FindBy(xpath = "//*[@class='css-14qn862']/input[@type='text' and @value='2']")
    private WebElement currentQuantityOfProductIsTwo;

    @FindBy(xpath = "//*[@d='M8 3.333v9.334M3.336 8h9.333']//.." )
    private WebElement increaseQuantityOfProduct;

    @FindBy(xpath = "//p[@class='css-1v8fwkm' and text()='15']")
    private WebElement subTotalPriceOfOneGommageInBag;

    @FindBy(xpath = "//p[@class='css-1v8fwkm' and text()='30']")
    private WebElement subTotalPriceOfTwoGommagesInBag;

    @FindBy(xpath = "//div[@class='bottom css-1wbf64e']/p[text()='15']")
    private WebElement TotalPriceOfOneGommageProduct;

    @FindBy(xpath = "//div[@class='bottom css-1wbf64e']/p[text()='30']")
    private WebElement TotalPriceOfTwoGommageProducts;

    @FindBy(xpath = "//*[@class='css-1q17b8j']")
    private WebElement removeProductFromBag;

    @FindBy(xpath = "//h1[contains(text(), \"haven't added any items to your bag yet.\")]" )
    private WebElement emptyBagMessage;

    public BagPage(WebDriver webDriver) {
        super(webDriver);
    }

    @Override
    protected String getRelativeUrl() {
        return "basket";
    }

    public BagPage removeProductFromBag() {
        clickOnElement(removeProductFromBag, "Remove product from bag");
        return this;
    }

    public BagPage checkIsEmptyBagMessageVisible() {
        checkIsElementVisible(emptyBagMessage, "Empty bag message");
        return this;
    }

    public BagPage checkIsSubTotalPriceOfOneGommageInBagVisible() {
        checkIsElementVisible(subTotalPriceOfOneGommageInBag, "Subtotal price of one gommage");
        return this;
    }

    public BagPage checkIsSubTotalPriceOfTwoGommagesInBagVisible() {
        checkIsElementVisible(subTotalPriceOfTwoGommagesInBag, "Subtotal price of two gommage products");
        return this;
    }

    public BagPage checkIsTotalPriceOfOneGommageProductVisible() {
        checkIsElementVisible(TotalPriceOfOneGommageProduct, "Total price of one gommage product");
        return this;
    }

    public BagPage checkIsTotalPriceOfTwoGommageProductsVisible() {
        checkIsElementVisible(TotalPriceOfTwoGommageProducts, "Total price of two gommage products");
        return this;
    }

    public BagPage checkIsCurrentQuantityOfProductIsOne() {
        checkIsElementVisible(currentQuantityOfProductIsOne, "Current quantity of product is one");
        return this;
    }

    public BagPage checkIsCurrentQuantityOfProductIsTwo() {
        checkIsElementVisible(currentQuantityOfProductIsTwo, "Current quantity of product is two");
        return this;
    }

    public BagPage increaseQuantityOfProductbyOne() {
        clickOnElement(increaseQuantityOfProduct, "Increase button");
        return this;
    }

    public BagPage checkIsProductOilInBagVisible() {
        checkIsElementVisible(productOilInBag, "The oil product in bag");
        return this;
    }

    public BagPage checkIsProductOilInBagNotVisible() {
        checkIsElementNotVisible(productOilInBag, "The oil product in bag");
        return this;
    }

    public BagPage checkIsProductGommageInBagVisible() {
        checkIsElementVisible(productGommageInBag, "The gommage product in bag");
        return this;
    }

    public BagPage checkIsProductGommageInBagNotVisible() {
        checkIsElementNotVisible(productGommageInBag, "The gommage product in bag");
        return this;
    }
}
