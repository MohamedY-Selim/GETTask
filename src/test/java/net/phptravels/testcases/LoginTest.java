package net.phptravels.testcases;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import net.phptravels.base.BaseTest;
import net.phptravels.config.EndPoint;
import net.phptravels.pages.HomePage;
import net.phptravels.pages.LoginPage;
import net.phptravels.pages.RegistrationPage;
import net.phptravels.utils.ConfigUtils;
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
