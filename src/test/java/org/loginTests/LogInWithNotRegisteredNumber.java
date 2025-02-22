package org.loginTests;

import org.baseTest.BaseTest;
import org.junit.Test;

public class LogInWithNotRegisteredNumber extends BaseTest {
    @Test
    public void T0005_logInWithNotRegisteredNumber() {
        pageProvider.getHomePage().openPage()
                .openRegistrationPage()
                .checkIsRedirectToRegistrationPage()
                .clickOnLoginButton()
                .checkIsRedirectToLoginPage()
                .enterNotRegisteredNumber()
                .clickOnGetAnSMSButton()
                .checkIsErrorMessageVisible()
        ;
    }
}
