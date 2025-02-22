package org.changeQuantityOfProductsInBagTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class ChangeQuantityOfGommageProductInBag extends BaseTest {
    @Test
    public void T0002_changeQuantityOfGommageProductInBag() {
        pageProvider.getHomePage().openPage()
                .openBurgerMenu()
                .openBodyCareCategory()
                .checkIsBodyCareHeaderVisible()
                .addGommageProductToBag()
                .checkIsProductAddToBagNotifVisible()
                .checkIsOneItemInBagVisible()
                .clickOnAddedProdctNotif()
                .openBag()
                .checkIsProductGommageInBagVisible()
                .checkIsCurrentQuantityOfProductIsOne()
                .checkIsSubTotalPriceOfOneGommageInBagVisible()
                .checkIsTotalPriceOfOneGommageProductVisible()
                .increaseQuantityOfProductbyOne()
                .checkIsCurrentQuantityOfProductIsTwo()
                .checkIsSubTotalPriceOfTwoGommagesInBagVisible()
                .checkIsTotalPriceOfTwoGommageProductsVisible()
                .removeProductFromBag()
                .checkIsProductGommageInBagNotVisible()
                .checkIsEmptyBagMessageVisible();

    }
}
