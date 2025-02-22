package org.pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.utils.ConfigProvider;

import java.time.Duration;
import java.util.List;

public class CommonActionsWithElements {
    protected WebDriver webDriver;
    private Logger logger = Logger.getLogger(getClass());
    protected WebDriverWait webDriverWait_10, webDriverWait_15, webDriverWait_30;

    public CommonActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        PageFactory.initElements(webDriver, this); //ініціалізує елементи описані FindBy
        webDriverWait_10 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_LOW()));
        webDriverWait_15 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_DEFAULT_WAIT()));
        webDriverWait_30 = new WebDriverWait(webDriver, Duration.ofSeconds(ConfigProvider.configProperties.TIME_FOR_EXPLICIT_WAIT_HIGH()));
    }

    protected boolean isElementVisible(WebElement webElement) {
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(getElementName(webElement) + " Element is displayed");
            } else {
                logger.info(getElementName(webElement) + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not found");
            return false;
        }
    }

    protected boolean isElementVisibleWithOutClickable(WebElement webElement, String elementName) {
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(elementName + " Element is displayed");
            } else {
                logger.info(elementName + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info(elementName +" is not found");
            return false;
        }
    }

    protected boolean isElementVisible(WebElement webElement, String elementName) {
        webDriverWait_10.until(ExpectedConditions.elementToBeClickable(webElement));
        try {
            boolean state = webElement.isDisplayed();
            if (state) {
                logger.info(elementName + " Element is displayed");
            } else {
                logger.info(elementName + " Element is not displayed");
            }
            return state;
        } catch (Exception e) {
            logger.info("Element is not found");
            return false;
        }
    }

    protected void clickOnElement(WebElement webElement) {
        try {
            webDriverWait_30.until(ExpectedConditions.elementToBeClickable(webElement));
            String elementName = getElementName(webElement);
            webElement.click();
            logger.info(elementName + " Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElement(WebElement webElement, String elementName) {
        try {
            webDriverWait_30.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(elementName + " element was clicked");
        } catch (Exception e) {
            logger.error("Can not work with element " + elementName);
            printErrorAndStopTest(e);
        }
    }

    protected void clickOnElementWithWaitAfter(WebElement webElement, String elementName) {
        try {
            webDriverWait_30.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info(elementName + " element was clicked");
            Thread.sleep(3000);
        } catch (Exception e) {
            logger.error("Can not work with element " + elementName);
            printErrorAndStopTest(e);
        }
    }

    protected void checkIsElementVisible(WebElement webElement) {
        Assert.assertTrue("Element is not visible", isElementVisible(webElement));
    }

    protected void checkIsElementVisible(WebElement webElement, String elementName) {
        Assert.assertTrue(elementName + " is not visible", isElementVisible(webElement, elementName));
    }

    protected void checkIsElementNotVisible(WebElement webElement, String elementName) {
        Assert.assertFalse(elementName + " is visible", isElementVisibleWithOutClickable(webElement, elementName));
    }

    protected void clearAndEnterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into the element " + getElementName(webElement));
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    private String getElementName(WebElement webElement) {
        String elementName;
        try {
            elementName = webElement.getAccessibleName();
        } catch (Exception e) {
            elementName = "";
        }
        return elementName;
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can't work with element " + e);
    }

    protected void setCheckboxAsChecked(WebElement webElement) {
        if (!webElement.isSelected()) {
            clickOnElement(webElement, "Unique post checkbox");
        } else {
            logger.info("Checkbox is already checked");
        }
    }

    public void checkOnlyPeelsElementsPresent(WebElement peelsProductElement) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.visibilityOf(peelsProductElement));

        List<WebElement> allPeelsElements = webDriver.findElements(By.xpath("//*[@class='" + peelsProductElement.getAttribute("class") + "']"));

        // Only with 'Peels'
        for (WebElement element : allPeelsElements) {
            String text = element.getText().trim();
            // Start from 'Peels'
            if (!text.matches("^Peels.*")) {
                Assert.fail("Found an item with text other than 'Peels': " + text);
            }
        }

        logger.info("Only 'Peels' are displayed on the page!");
    }
}
