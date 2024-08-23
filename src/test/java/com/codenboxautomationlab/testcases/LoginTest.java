package com.codenboxautomationlab.testcases;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import com.codenboxautomationlab.base.BaseTest;
import com.codenboxautomationlab.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Signup Feature")
public class LoginTest extends BaseTest {
    @Story("Login Page")
    @Test(description = "Attempt to Login")
    public void VerifyThatUserCanLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isErrorMessageDisplayed = loginPage
                .load()
                .fillLoginForm()
                .isErrorMessageDisplayed();
        Assert.assertFalse(isErrorMessageDisplayed);
    }

}
