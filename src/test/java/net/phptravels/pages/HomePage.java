package net.phptravels.pages;

import io.qameta.allure.Step;
import net.phptravels.base.BasePage;
import net.phptravels.utils.ConfigUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class HomePage extends BasePage {

    //Constructor
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(id = "menu-item-202")
    private WebElement courseSignupButton;
    @FindBy(id = "menu-item-107")
    private WebElement registrationFormButton;

    //Methods
    @Step("Load the home page")
    public HomePage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl());
        return this;
    }

    @Step("Hover Over Signup Button")
    public HomePage hoverOverSignupButton() {
        actions().moveToElement(courseSignupButton).perform();
        return new HomePage(driver);
    }

    @Step("Click on Registration form button")
    public RegistrationPage clickOnRegistrationFormButton() {
        registrationFormButton.click();
        return new RegistrationPage(driver);
    }


}
