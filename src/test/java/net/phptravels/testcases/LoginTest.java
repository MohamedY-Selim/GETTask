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

    @Story("Home Page")
    @Test(description = "Navigate to login page")
    public void VerifyThatUserCanNavigateToLoginPageSuccessfully() {
        HomePage homePage = new HomePage(getDriver());
        boolean loginFormDisplayed = homePage
                .load()
                .clickOnLoginButton().isLoginFormDisplayed();
        Assert.assertTrue(loginFormDisplayed);
        Assert.assertEquals(homePage.getCurrentPageUrl(), ConfigUtils.getInstance().getBaseUrl() + EndPoint.LOGIN_PAGE_END_POINT);
    }

    @Story("Login Page")
    @Test(description = "Attempt to Login")
    public void VerifyThatUserCanLogin() {
        LoginPage loginPage = new LoginPage(getDriver());
        boolean isErrorMessageDisplayed = loginPage
                .load()
                .isErrorMessageDisplayed();
        Assert.assertFalse(isErrorMessageDisplayed);
    }

}
