package org.addProductToBagTest;

import org.baseTest.BaseTest;
import org.junit.Test;

public class AddOilProductInBag extends BaseTest {
     @Test
     public void T0001_addOilProductToBag() {
         pageProvider.getHomePage().openPage()
                 .openBurgerMenu()
                 .openBodyCareCategory()
                 .addOilProductToBag()
                 .checkIsProductAddToBagNotifVisible()
                 .checkIsOneItemInBagVisible()
                 .clickOnAddedProdctNotif()
                 .openBag()
                 .checkIsProductOilInBagVisible();

     }
}
