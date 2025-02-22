package org.productsFilteringTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class FilterProductsByTitle extends BaseTest {
    @Test
    public void T0004_filterProductsByTitle() {
        pageProvider.getHomePage().openPage()
                .clickOnViewProductsButton()
                .checkIsRedirectToProductsPage()
                .setPeelsCheckbox()
                .clickOnSearchByFilterButton()
                .checkIsOnlyPeelsProductsVisible()
        ;
    }
}
