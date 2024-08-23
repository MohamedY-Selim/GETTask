package com.codenboxautomationlab.testcases;

import com.codenboxautomationlab.base.BaseTest;
import com.codenboxautomationlab.config.EndPoint;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import com.codenboxautomationlab.pages.HomePage;
import com.codenboxautomationlab.pages.RegistrationPage;
import com.codenboxautomationlab.utils.ConfigUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

@Feature("Signup Feature")
public class SignupTest extends BaseTest {

    @Story("Home Page")
    @Test(description = "Navigate to registration page")
    public void VerifyThatUserCanNavigateToRegistrationPageSuccessfully() {
        HomePage homePage = new HomePage(getDriver());
        String signupHeaderText = homePage
                .load()
                .hoverOverSignupButton()
                .clickOnRegistrationFormButton()
                .getRegistrationHeaderText();
        Assert.assertEquals(signupHeaderText, "Training Registration Form");
        Assert.assertEquals(homePage.getCurrentPageUrl(), ConfigUtils.getInstance().getBaseUrl() + EndPoint.SIGNUP_PAGE_END_POINT);
    }

    @Story("Signup Page")
    @Test(description = "Register using correct data")
    public void VerifyThatUserCanRegisterUsingCorrectData() throws InterruptedException {
        RegistrationPage registrationPage = new RegistrationPage(getDriver());
        String confirmationMessage = registrationPage
                .load()
                .fillRegistrationForm()
                .getConfirmationMessage();
        Assert.assertEquals(confirmationMessage,"Your registration is completed. We will contact with you soon. Thank you !");
        ConfigUtils.getInstance().setNewUserData(registrationPage.getUser().getEmail(),registrationPage.getUser().getPhone());
    }

}
