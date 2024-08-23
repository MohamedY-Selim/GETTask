package net.phptravels.pages;

import io.qameta.allure.Step;
import net.phptravels.base.BasePage;
import net.phptravels.config.EndPoint;
import net.phptravels.utils.ConfigUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {

    //Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(id = "loginform")
    private WebElement loginForm;
    @FindBy(id = "user_login")
    private WebElement loginInput;
    @FindBy(id = "user_pass")
    private WebElement passwordInput;
    @FindBy(id = "rememberme")
    private WebElement rememberMeCheckbox;
    @FindBy(xpath = "//button[@aria-label='Show password']")
    private WebElement showPassworlToggle;
    @FindBy(id = "wp-submit")
    private WebElement loginButton;
    @FindBy(id = "login_error")
    private WebElement errorMessage;

    //Methods
    @Step("Load the signup page")
    public LoginPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.SIGNUP_PAGE_END_POINT);
        return this;
    }


    @Step("Fill Login form")
    public LoginPage fillLoginForm() {
        loginInput.sendKeys(ConfigUtils.getInstance().getEmail());
        passwordInput.sendKeys(ConfigUtils.getInstance().getPassword());
        showPassworlToggle.click();
        rememberMeCheckbox.click();
        loginButton.click();
        return this;
    }

    @Step("Get login form display status")
    public boolean isLoginFormDisplayed() {
        return loginForm.isDisplayed();
    }

    @Step("Get error message display status")
    public boolean isErrorMessageDisplayed() {
        explicitWait().until(ExpectedConditions.visibilityOf(errorMessage));
        return errorMessage.isDisplayed();
    }
}
