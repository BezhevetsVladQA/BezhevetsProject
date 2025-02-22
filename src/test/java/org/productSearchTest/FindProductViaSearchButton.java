package org.productSearchTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class FindProductViaSearchButton extends BaseTest {
    @Test
    public void T0003_findProductViaSearchButton() {
        pageProvider.getHomePage().openPage()
                .clickOnSearchButton()
                .checkIsSearchInputFieldVisible()
                .enterTextToSearchInputField("Massaging Oil")
                .clickOnSearchButtonOfInputField()
                .checkIsResultsPageIsOpened()
                .checkIsOilProductOilIsFound()
        ;
    }
}
