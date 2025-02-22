package org.addProductToBagTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class AddOilProductInBag extends BaseTest {
    @Test
    public void T0001_addOilProductToBag() {
        pageProvider.getHomePage().openPage()
                .openBurgerMenu()
                .openBodyCareCategory()
                .checkIsBodyCareHeaderVisible()
                .addOilProductToBag()
                .checkIsProductAddToBagNotifVisible()
                .checkIsOneItemInBagVisible()
                .clickOnAddedProdctNotif()
                .openBag()
                .checkIsRedirectToBagPage()
                .checkIsProductOilInBagVisible()
                .removeProductFromBag()
                .checkIsProductOilInBagNotVisible()
                .checkIsEmptyBagMessageVisible();
    }
}
