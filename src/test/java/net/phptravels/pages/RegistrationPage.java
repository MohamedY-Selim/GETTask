package net.phptravels.pages;

import io.qameta.allure.Step;
import net.phptravels.base.BasePage;
import net.phptravels.config.EndPoint;
import net.phptravels.objects.User;
import net.phptravels.utils.ConfigUtils;
import net.phptravels.utils.UserUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class RegistrationPage extends BasePage {
    User user;

    //Constructor
    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    //Elements
    @FindBy(xpath = "//div[@class=\"entry-content\"]//h2")
    private WebElement registrationHeader;
    @FindBy(id = "nf-field-17")
    private WebElement firstNameInput;
    @FindBy(id = "nf-field-18")
    private WebElement lastNameInput;
    @FindBy(id = "nf-field-19")
    private WebElement emailInput;
    @FindBy(id = "nf-field-20")
    private WebElement phoneInput;
    @FindBy(id = "nf-field-22")
    private WebElement courseDropdown;
    @FindBy(id = "nf-field-24")
    private WebElement monthDropdown;
    @FindAll({
            @FindBy(xpath = "//input[@name=\"nf-field-23\"]")
    })
    private List<WebElement> sourceOfKnown;
    @FindBy(id = "nf-field-15")
    private WebElement registerButton;
    @FindBy(className = "nf-response-msg")
    private WebElement confirmationMessage;

    //Methods
    @Step("Load the signup page")
    public RegistrationPage load() {
        driver.get(ConfigUtils.getInstance().getBaseUrl() + EndPoint.SIGNUP_PAGE_END_POINT);
        return this;
    }

    @Step("Get registration form Header Text")
    public String getRegistrationHeaderText() {
        String registrationHeaderText = registrationHeader.getText();
        return registrationHeaderText;
    }

    @Step("Fill Registration form")
    public RegistrationPage fillRegistrationForm() {
        user = UserUtils.generateRandomUser();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        phoneInput.sendKeys(user.getPhone());
        selectRandomOptionByIndexFromDropDown(courseDropdown);
        selectRandomOptionByIndexFromDropDown(monthDropdown);
        clickOnSOKRadio(sourceOfKnown.get(random(sourceOfKnown.size())));
        registerButton.click();
        return this;
    }

    public void clickOnSOKRadio(WebElement radioButton) {

        WebElement label = driver.findElement(By.cssSelector("label[for='" + radioButton.getAttribute("id") + "']"));
        label.click();
    }

    public String getConfirmationMessage() {
        explicitWait().until(ExpectedConditions.visibilityOf(confirmationMessage));
        return confirmationMessage.getText();
    }

    public User getUser() {
        return user;
    }

}
